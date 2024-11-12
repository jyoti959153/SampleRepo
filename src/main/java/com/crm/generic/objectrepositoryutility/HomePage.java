package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink1;

	public WebElement getOrgLink1() {
		return orgLink1;
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgIcon;

	public WebElement getOrgIcon() {
		return orgIcon;
	}

	
	@FindBy(linkText="Contacts")
	private WebElement contactLink1;

	public WebElement getContactLink1() {
		return contactLink1;
	
	
  
	}

	
	
	

	
	}

	

