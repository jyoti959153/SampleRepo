package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	
	public ContactsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
  public WebElement getContactsLink2() {
		return contactsLink2;
	}

	public void setContactsLink2(WebElement contactsLink2) {
		this.contactsLink2 = contactsLink2;
	}

	public WebElement getCreateconIcon() {
		return createconIcon;
	}

	public void setCreateconIcon(WebElement createconIcon) {
		this.createconIcon = createconIcon;
	}

@FindBy(linkText="Contacts")
  private WebElement contactsLink2;
  
  @FindBy(xpath="//img[@alt=\"Create Contact...\"]")
  private WebElement createconIcon;

}
