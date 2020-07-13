package com.AudenTest.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import com.AudenTest.pageObjects.AudenShortTermLoanPage;

public class TC_ShortTermLoan_SetAmount_001 extends BC_BaseClass_ShortTermLoan_01
{
	
	@Test
	public void setAmountSlider()
	{
//		Actions act = new Actions(driver);
//		final WebElement AmountSlider = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/section[1]/div/label/input"));
//		final WebElement AmountSet = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/section[1]/header/div[2]/span"));
//		final WebElement FirstRepayment = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/section[2]/div/div[2]/span[2]/span"));;
		
		driver.get(baseurl);
		
		
		AudenShortTermLoanPage LP = new AudenShortTermLoanPage(driver);
		
		//.setamout will not work ?
		LP.setAmount(amount);
		LP.setRepaymentDay(repaymentday);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		act.dragAndDropBy(AmountSlider, -100, 0).perform();
//		//get the output of the set amount to sysout....Will address third given assertion of the test....need to find a more elegant
//		System.out.println("The amount set by the slider is --->"+AmountSet.getText());
//		//Set repayment day
//		LP.setRepaymentDay(repaymentday);
//		System.out.println("FirstRepayment Date and day is ---->"+FirstRepayment.getText());
		
		if(repaymentday.equals("300"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false); 
		}
		
		
	}
	
}
