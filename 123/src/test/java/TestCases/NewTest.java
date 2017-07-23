package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import Config.Const;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	WebDriver driver;
	public static Logger Log = Logger.getLogger(NewTest.class.getName());
	
	
  @Test
  //(priority = 0)
  public void Login() throws Exception {
	  driver.findElement(By.name("uid")).sendKeys(Const.UserId);
	  Log.info("########	Enter UserName as "+Const.UserId+" website	#############");
	  driver.findElement(By.name("password")).sendKeys(Const.password);
	  Log.info("########	Enter UserName as "+Const.password+" website	#############");
	  driver.findElement(By.name("btnLogin")).click();
	  Thread.sleep(5000);
	  Log.info("########	Clicked on Login Button	#############");
	  Reporter.log("Successfully Logged In");
  }
  
  @Test
  //(priority = 1, enabled = false)
  public void Logout() throws Exception {
	  driver.findElement(By.linkText("Log out")).click();
	  Thread.sleep(5000);
	  Log.info("########	Clicked on Logout Button	#############");
	  Reporter.log("Successfully Logged Out");
  }
  
  @BeforeClass
  public void beforeTest() {
	  DOMConfigurator.configure("log4j.xml");
	  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "C:\\geckodriver-v0.17.0-win64\\chromedriver.exe");
	  //driver = new FirefoxDriver();
	  driver = new ChromeDriver();
	  Log.info("########	Browser Open	#############");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(Const.URL);	  
	  Log.info("########	Navigate to "+Const.URL+" website	#############");
  }

  @AfterClass
  public void afterTest() {
	  driver.quit();
	  
  }

}
