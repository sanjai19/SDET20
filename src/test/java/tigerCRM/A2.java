package tigerCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A2 {

	public static void main(String[] args) {
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
		drivers.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		Actions action = new Actions(drivers);
		action.moveToElement(drivers.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).perform();
		drivers.findElement(By.linkText("Sign Out")).click();

		drivers.quit();
	}

}
