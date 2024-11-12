package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink2;
	
	
	public WebElement getOrgLink2() {
		return orgLink2;
	}


	public WebElement getCreateOrgIcon() {
		return createOrgIcon;
	}


	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgIcon; 
	
	
	public WebElement getSearchforTf() {
		return searchforTf;
	}


	public WebElement getSearchDropdown() {
		return searchDropdown;
	}

	@FindBy(name="search_text")
	private WebElement searchforTf;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchDropdown;
	
	public void searchDropdown()
	{
	Select s1=new Select(searchDropdown);
	s1.selectByVisibleText("Organization Name");
	}
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	@FindBy(linkText = "ORGANIZATIONS")
	private WebElement organizationLink;
	
	@FindBy(name="submit")
	private WebElement serachbtn;
	public WebElement getSerachbtn() {
		return serachbtn;
	}
	
    
	}
	
	
	
	
	


