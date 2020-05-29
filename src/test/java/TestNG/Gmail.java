package TestNG;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Gmail {
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	
	@BeforeTest
	public void setReport(){
		htmlReporter=new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Test Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Report", "Ganesh");
	}

	@BeforeClass
	public void endReport(){
		extent.flush();	
	}
	
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
		
		test=extent.createTest("Launch Browser");
		if(bN.equalsIgnoreCase("chrome")){
		System.out.println("Launching Chrome Browser -->"+bN);	
		}
		System.out.println("Launching Browser");		
	}

	@Test(priority=1)
	public void loadGmail(){
		test=extent.createTest("Loading Gmail");
		System.out.println("Loading Gmail");
		Assert.assertEquals("gmail", "gmail");
	}

	@Test(priority=2,dependsOnMethods="loadGmail")
	public void composeMail(){
		test=extent.createTest("Compose Gmail");
		System.out.println("Composing G-Mail");		
	}
	
	@Test(priority=3,dependsOnMethods="loadGmail")
	public void Logout(){
		test=extent.createTest("Logout Gmail");
		System.out.println("Gmail Logout");		
	}

	@Test(priority=4)
	public void closeDB(){
		test=extent.createTest("Closing DB Connection");
		System.out.println("Closing DB Connection");
		String expected="E";
		String actual="E";
		Assert.assertEquals(expected, actual);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.SUCCESS){
			
			String methodName=result.getMethod().getMethodName();
			
			Markup m=MarkupHelper.createLabel(methodName, ExtentColor.GREEN);
			test.pass(m);
		}
		else if(result.getStatus()==ITestResult.FAILURE){
			
			String methodName=result.getMethod().getMethodName();
			
			Markup m=MarkupHelper.createLabel(methodName, ExtentColor.RED);
			test.fail(m);
		}
	}

}
