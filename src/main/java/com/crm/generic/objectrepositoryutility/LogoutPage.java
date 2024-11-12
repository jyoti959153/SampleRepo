package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administor;
	
	public WebElement getAdministor() {
		return administor;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;

	public void logout() throws InterruptedException
	{
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	act.click(administor).perform();
	//administor.click();
	Thread.sleep(2000);
	signout.click();
	}

}
