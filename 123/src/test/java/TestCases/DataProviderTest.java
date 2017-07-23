package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
	WebDriver driver;
	public static Logger Log = Logger.getLogger(NewTest.class.getName());
	
	
  @Test(dataProvider = "Checkin")
  //@Parameters({ "sUsername", "sPassword" })
  //(priority = 0)
  public void Login(String sUsername, String sPassword) throws InterruptedException  {
	  driver.findElement(By.name("uid")).sendKeys(sUsername);
	  Log.info("########	Enter UserName as "+sUsername+" website	#############");
	  driver.findElement(By.name("password")).sendKeys(sPassword);
	  Log.info("########	Enter UserName as "+sPassword+" website	#############");
	  Thread.sleep(5000);
	  WebElement btn = driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]")); 
	  try {
	  btn.click();
	  }catch(Exception e){
		System.out.println("error");  
	  }
	  Thread.sleep(5000);
	  Log.info("########	Clicked on Login Button	#############");
	  Reporter.log("Successfully Logged In");
	  driver.findElement(By.linkText("Log out")).click();
	  Thread.sleep(5000);
	  Log.info("########	Clicked on Logout Button	#############");
	  Reporter.log("Successfully Logged Out");
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  Thread.sleep(5000);
  }
  
  
  @Test
  (enabled = false)
  public void Logout() throws Exception {
	  
  }
  
  
  
  @BeforeMethod
  
  @Parameters({"URL"})
  
  public void beforeTest(String URL) {
	  DOMConfigurator.configure("log4j.xml");
	  //System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "C:\\geckodriver-v0.17.0-win64\\chromedriver.exe");
	  //driver = new FirefoxDriver();
	  driver = new ChromeDriver();
	  Log.info("########	Browser Open	#############");
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(URL);	  
	  Log.info("########	Navigate to "+URL+" website	#############");
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
	
  }
  @DataProvider(name = "Checkin")
  
  public static Object[][] credentials() {
      return new Object[][] {{"mngr86807","UrUbApE"}};

}
}
