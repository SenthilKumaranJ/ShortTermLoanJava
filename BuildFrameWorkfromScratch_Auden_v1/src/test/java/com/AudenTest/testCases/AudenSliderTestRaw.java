package com.AudenTest.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AudenSliderTestRaw 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		/*Chromedriver 
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for Chromedriver*/
		
		//firefox driver 
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//firefox driver
		
		driver.manage().window().maximize();
		driver.get("https://www.auden.co.uk/credit/shorttermloan");
//		driver.get("https://rangeslider.js.org/");
	}
	
	@Test
	public void dragslider()
	{
		
				
		//Webelement for slider....There is no separate element for slider handle....tricky
		//WebElement Slider=driver.findElement(By.xpath("//*[contains(@data-testid,\"loan-calculator-slider\" )]"));
		//WebElement Slider=driver.findElement(By.xpath("//*[@id=\"js-rangeslider-0\"]/div[2]"));
		WebElement Slider=driver.findElement(By.cssSelector(".loan-amount__range-slider__input"));
		//*[@id="js-rangeslider-0"]/div[2]
		//element = findElement(By.xpath("//*[@test-id='test-username']");
		//element = findElement(By.xpath("//input[@test-id='test-username']");
		
		//WebElement for Slider Value
		WebElement SliderResultValue=driver.findElement(By.cssSelector(".loan-amount__header__amount [data-testid=\"loan-amount-value\"]"));
		//WebElement SliderResultValue=driver.findElement(By.xpath("id(\"root\")/div[@class=\"main-wrapper-main-EdHEf215nn\"]/div[@class=\"landing-page\"]/div[@class=\"row\"]/div[@class=\"landing-page__container\"]/div[@class=\"right-wrapper\"]/div[@class=\"loan-calculator\"]/section[@class=\"loan-amount\"]/header[@class=\"loan-amount__header\"]/div[@class=\"loan-amount__header__amount\"]/span[1]"));
		//WebElement SliderResultValue=driver.findElement(By.xpath("//*[@id=\"js-output\"]"));
		
		//WebElements for repayment date
		WebElement RepaymentDay1=driver.findElement(By.xpath("//*[@id='monthly'and@value='1']"));
		WebElement RepaymentDay2=driver.findElement(By.cssSelector(".date-selector__date[name=\"day\"][value=\"2\"]"));
		//WebElement for CheckEligibility button
		WebElement ClickEligibility=driver.findElement(By.cssSelector(".loan-calculator__apply[type=\"button\"]"));
//		//WebElement for Calculated loan amount
//		WebElement CalculatedLoanAmount=driver.findElement(By.cssSelector(".loan-summary__column__amount__value"));
//		
		//Actions
		//Slider Action
		String MinimumSliderValue = "£200"; //To Be moved to Data container class
		String MaximumSliderValue = "£500"; //To Be moved to Data container class
		if (MinimumSliderValue.equals(SliderResultValue.getText()))
		{
			Assert.assertTrue(true, "Passed: Minimum Slider value equals"+SliderResultValue.getText());
		}
		else
		{
			Assert.assertTrue(false, "Failed: Minimum Slider value equals"+SliderResultValue.getText());
		}
		Actions act=new Actions(driver);
		//act.dragAndDropBy(Slider,100, 0).build().perform();
		act.dragAndDropBy(Slider,300, 0).build().perform();
		if (MaximumSliderValue.equals(SliderResultValue.getText()))
		{
			Assert.assertTrue(true, "Passed: Minimum Slider value equals"+SliderResultValue.getText());
		}
		else
		{
			Assert.assertTrue(false, "Failed: Minimum Slider value equals"+SliderResultValue.getText());
		}		
		//Click on repayment date element
		WebDriverWait wait=new WebDriverWait(driver, 20);
		RepaymentDay1=wait.until(ExpectedConditions.elementToBeClickable(RepaymentDay1));
		RepaymentDay1.click();
		
		ClickEligibility.click();
		
		//WebElement for Calculated loan amount
		WebElement CalculatedLoanAmount=driver.findElement(By.cssSelector(".loan-summary__column__amount__value"));
		System.out.println("Calculated Loan amount ->>"+(CalculatedLoanAmount.getText().substring(1)));
		System.out.println("Value of Slider--->"+SliderResultValue.getText());
				
		//Assertion for Slider value= calculated loan value
		Assert.assertEquals(CalculatedLoanAmount.getText().substring(0, 4), SliderResultValue.getText(), "Slider Value Vs calculated Value Assert");
//		if ((CalculatedLoanAmount.getText().substring(1)).equals(SliderResultValue.getText().substring(1)))
//		{
//			Assert.assertTrue(true, "PASSED: Assertion 3: Calculated loan Value is equal to slider value");
//		}
//		else
//		{
//			Assert.assertTrue(false, "Failed: Assertion 3: Calculated loan Value is not equal to slider value");
//		}
		System.out.println("Value of RepaymentDateSelected--->"+RepaymentDay2.getText());
		System.out.println("Value of RepaymentDateSelected--->"+RepaymentDay1.getText());
		System.out.println("Value of Slider--->"+SliderResultValue.getText());
	}
//	@AfterClass
//	public void closedown()
//	{
//		driver.quit();
//	}

}
