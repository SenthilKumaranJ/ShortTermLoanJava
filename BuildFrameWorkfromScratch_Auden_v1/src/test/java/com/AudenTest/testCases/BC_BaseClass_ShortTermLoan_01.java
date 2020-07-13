package com.AudenTest.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BC_BaseClass_ShortTermLoan_01 {
	public String baseurl = "https://www.auden.co.uk/credit/shorttermloan";
	//The amount variable set below might be useless - Cleanup
	public String amount="300";
	public String repaymentday="7";
	public static WebDriver driver;
	

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get(baseurl);
		
	}
	
	@AfterClass
	public void closedown()
	{
		driver.quit();
	}
}
