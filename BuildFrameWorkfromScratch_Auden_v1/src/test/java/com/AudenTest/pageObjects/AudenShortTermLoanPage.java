package com.AudenTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudenShortTermLoanPage {
	
	WebDriver ldriver;
	
	/* constructor for loan page objects*/
	public AudenShortTermLoanPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
				
	}
	
	/*Below object maybe wrong...It is a slider...cleanup required after confirmation*/
	@FindBy(name="amount")
	@CacheLookup
	WebElement NumAmount;
	
	/*amount as a slider element....maybe this will work??*/
	@CacheLookup
	WebElement AmountSlider = ldriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/section[1]/div/label/input"));
	
	/*To read the amount set by the slider after it is set*/
	WebElement AmountSet = ldriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/section[1]/header/div[2]/span"));
	
	@FindBy(name="day")
	@CacheLookup
	WebElement NumRepaymentDay;
	
	/*dataid below is actually data-id.... */
	@FindBy(name="monthly")
	@CacheLookup
	WebElement txtFirstRepayment;
	
	public void setAmount(String amount)
	{
		NumAmount.sendKeys(amount);
	}
	
	public void setRepaymentDay(String RepaymentDay)
	{
		NumRepaymentDay.click();
		//NumRepaymentDay.sendKeys(RepaymentDay);
	}
	
}
