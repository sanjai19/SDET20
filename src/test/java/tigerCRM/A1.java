package tigerCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class A1 {

		public static void main(String[] args) throws Throwable {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver drivers = new ChromeDriver();
			drivers.manage().window().maximize();
			drivers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			drivers.get("http://localhost:8888/");

			drivers.findElement(By.name("user_name")).sendKeys("admin");
			drivers.findElement(By.name("user_password")).sendKeys("admin");
			drivers.findElement(By.id("submitButton")).click();
			
			drivers.findElement(By.linkText("Organizations")).click();
			drivers.findElement(By.cssSelector("img[title='Create Organization...']")).click();
			drivers.findElement(By.name("accountname")).sendKeys("Tesla");
			Select s = new Select(drivers.findElement(By.name("industry")));
			s.selectByValue("Banking");
			Select s1 = new Select(drivers.findElement(By.name("rating")));
			s1.selectByValue("Active");
			Select s2 = new Select(drivers.findElement(By.name("accounttype")));
			s2.selectByValue("Customer");
		
			drivers.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
			Thread.sleep(3000);
			Actions action = new Actions(drivers);
			action.moveToElement(drivers.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).perform();
			drivers.findElement(By.linkText("Sign Out")).click();
			
			drivers.quit();
}
}
