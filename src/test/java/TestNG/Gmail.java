package TestNG;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Gmail {
	
	
	
	
	
	WebDriver driver;

	@BeforeSuite
	public void beforesuite(){
		System.out.println("Before Suite");	
		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void afterSuite(){
		
		driver.close();
	}

	@Test(priority=0)
	@Parameters("browser")
	public void launchBrowser(String bN){
		
		
		if(bN.equalsIgnoreCase("chrome")){
		System.out.println("Launching Chrome Browser -->"+bN);	
		}
		System.out.println("Launching Browser");		
	}

	@Test(priority=1)
	public void loadGmail(){
		
		System.out.println("Loading Gmail");
		Assert.assertEquals("gmail", "gmail");
	}

	@Test(priority=2,dependsOnMethods="loadGmail")
	public void composeMail(){
		System.out.println("Composing G-Mail");		
	}
	
	@Test(priority=3,dependsOnMethods="loadGmail")
	public void Logout(){
		System.out.println("Gmail Logout");		
	}

	@Test(priority=4)
	public void closeDB(){
	
		System.out.println("Closing DB Connection");
		String expected="E";
		String actual="A";
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test(priority=5)
	public void skipTestcase(){
	
		System.out.println("Test case skip");
		throw new SkipException("Skiping the Test Case");
		
	}
	
	
	
}
