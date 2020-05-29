package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Nexxus {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.nexxus.com/uk/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		WebElement f=driver.findElement(By.xpath("//*[@id=\"cqcqPanel\"]/iframe"));
		driver.switchTo().frame(f);
		driver.findElement(By.xpath("//a[@class='acceptbutton']")).click();
				
	}

}
