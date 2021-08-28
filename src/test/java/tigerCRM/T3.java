package tigerCRM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T3 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver drivers = new ChromeDriver();
		drivers.manage().window().maximize();
		drivers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drivers.get("http://localhost:8888/");
		
		drivers.findElement(By.name("user_name")).sendKeys("admin");
		drivers.findElement(By.name("user_password")).sendKeys("admin");
		drivers.findElement(By.id("submitButton")).click();
		
		drivers.findElement(By.linkText("Contacts")).click();
		drivers.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		drivers.findElement(By.name("lastname")).sendKeys("elon musk");
		String parent = drivers.getWindowHandle();
		drivers.findElement(By.cssSelector("img[title='Select']")).click();
		//drivers.findElement(By.xpath("input[@name='account_name']/../img[@title='Select']")).click();
		
		Set<String> allwindowid = drivers.getWindowHandles();
		for(String str:allwindowid)
		{
			drivers.switchTo().window(str);
			if(drivers.getTitle().equals("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=12"))
			{
				drivers.manage().window().maximize();
				//break;
			}

			Thread.sleep(5000);
			
			drivers.findElement(By.xpath("//td[text()=' Administrator']/../td/a")).click();
			
			drivers.close();
		}
		drivers.switchTo().window(parent);
		drivers.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		Actions action = new Actions(drivers);
		action.moveToElement(drivers.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).perform();
		drivers.findElement(By.linkText("Sign Out")).click();

		drivers.quit();
	}

}
