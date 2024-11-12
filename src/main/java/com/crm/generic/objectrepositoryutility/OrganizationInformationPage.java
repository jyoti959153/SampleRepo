package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(id="mouseArea_Industry")
private WebElement industryInTf;

public WebElement getIndustryInTf() {
	return industryInTf;
}

public WebElement getTypeInTf() {
	return typeInTf;
}

@FindBy(id="mouseArea_Type")
private WebElement typeInTf;

@FindBy(linkText = "Organizations")
private WebElement orgLink;

public WebElement getOrgLink() {
	return orgLink;
}


}
