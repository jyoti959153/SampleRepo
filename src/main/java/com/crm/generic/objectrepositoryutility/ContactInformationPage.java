package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
WebDriver driver;

public ContactInformationPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}
@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
private WebElement contactsInHeader;

public WebElement getContactsInHeader() {
	return contactsInHeader;
}

public void setContactsInHeader(WebElement contactsInHeader) {
	this.contactsInHeader = contactsInHeader;
}

public WebElement getContactsInTf() {
	return contactsInTf;
}

public void setContactsInTf(WebElement contactsInTf) {
	this.contactsInTf = contactsInTf;
}

@FindBy(id="mouseArea_Last Name")
private WebElement contactsInTf;

}
