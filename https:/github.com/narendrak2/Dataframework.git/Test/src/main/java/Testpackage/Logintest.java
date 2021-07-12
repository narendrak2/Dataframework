package Testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {

	public static WebDriver driver=null;
	
	@BeforeMethod
	public void setup() {
		
		
		//System.setProperty("webdriver.chrome.driver","Users/narendra/Downloads/chromedriver 15");
		driver=new SafariDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://accounts.datoms.io/login");
	}
	@Test(priority=1,description="checking with not registered email id")
	public void logincheckwithwrongemail() throws InterruptedException {
		
		driver.findElement(By.id("email")).sendKeys("Narend@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		String actaulstring=driver.findElement(By.xpath("//div[@id='show_message']")).getText();
		
		Assert.assertEquals(actaulstring,"Email id does not exist!");
		Thread.sleep(2000);	
	}

@Test(priority=2,description="checking with valid email id")
public void checkloginwithwrongpassword() throws InterruptedException {

	driver.findElement(By.id("email")).sendKeys("Narenda");
	driver.findElement(By.id("password")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	
	String actaulstring=driver.findElement(By.xpath("//div[@id='show_message']")).getText();
	
	Assert.assertEquals(actaulstring,"Please enter a valid email!");
	Thread.sleep(2000);	
}

@Test(priority=3,description="No entry in field and clicking on login button")
public void Checkloginwithemptyfield() throws InterruptedException {
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	
	String actaulstring=driver.findElement(By.xpath("//div[@id='show_message']")).getText();
	
	Assert.assertEquals(actaulstring,"Email field cannot be empty!");
	Thread.sleep(2000);	
}
	

@Test(priority=4,description="Forgot password check")
public void Forgotpasswordcheck() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@href='/forgot']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
    String actaulstring1=driver.findElement(By.xpath("//div[@id='show_message']")).getText();
	
	Assert.assertEquals(actaulstring1,"Email field cannot be empty!");
	Thread.sleep(3000);	
	driver.findElement(By.id("email")).sendKeys("narendra@gmail.com");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	
} 
	@AfterMethod
	public void quit() {
	
		driver.quit();
	}
	
}
