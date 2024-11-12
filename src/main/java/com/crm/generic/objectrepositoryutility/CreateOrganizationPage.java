package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateOrganizationPage {
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getOrgTf() {
		return orgTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	@FindBy(name="accountname")
	private WebElement orgTf;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInHeader;
	
	public WebElement getOrgInHeader() {
		return orgInHeader;
	}


	public WebElement getOrgInTf() {
		return orgInTf;
	}


	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgInTf;
	
	public WebElement getPhoneNumberTf() {
		return phoneNumberTf;
	}


	@FindBy(id="phone")
	private WebElement phoneNumberTf;

	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	
	public void selectIndustry()
	{
	Select s1=new Select(industryDropdown);
	s1.selectByValue("Energy");
	}
		
	public void selectType()
	{
	Select s2=new Select(typeDropdown);
	s2.selectByValue("Press");
	}	
	
	public WebElement getPhoneNumberInHeader() {
		return phoneNumberInHeader;
	}


	public void setPhoneNumberInHeader(WebElement phoneNumberInHeader) {
		this.phoneNumberInHeader = phoneNumberInHeader;
	}


	public WebElement getPhoneNumberInTf() {
		return phoneNumberInTf;
	}


	public void setPhoneNumberInTf(WebElement phoneNumberInTf) {
		this.phoneNumberInTf = phoneNumberInTf;
	}


	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement phoneNumberInHeader;
	

	@FindBy(id="mouseArea_Phone")
	private WebElement phoneNumberInTf;
	
	public void createOrganization(String orgname)
	{
	orgTf.sendKeys(orgname);
	saveBtn.click();
	}
	
	public void verifyingInHeader(String expectedOrganame)
	{
	String actual = orgInHeader.getText();
	if (actual.contains(expectedOrganame)) {
	System.out.println("expectedOrganame in header verified ");
	} else {
	System.out.println("expectedOrganame in header not verified");
	}
	//Assert.assertEquals(actual, expectedOrganame);
	}
	
	public void verifyingInTf(String expected)
	{
	String actual = orgInTf.getText();
	if (actual.contains(expected)) {
	System.out.println("expected in textfield verified ");
	} else {
	System.out.println("expected in textfield not verified");
	}
	//Assert.assertEquals(actual, expected);
	}
	
	public void createOrgWithPhoneNumber(String orgname,String phonenumber)
	{
	orgTf.sendKeys(orgname);
	phoneNumberTf.sendKeys(phonenumber);
	saveBtn.click();
	}
	
	public void verifyingInPhoneNumber(String expectedPhoneNumber)
	{
	String actualPhonenumber = phoneNumberInTf.getText();
	if (actualPhonenumber.trim().equals(expectedPhoneNumber)) {
	System.out.println("expectedPhoneNumber in textfield verified ");
	} else {
	System.out.println("expectedPhoneNumber in textfield not verified");
	}
	//Assert.assertEquals(actualPhonenumber, expectedPhoneNumber);
	}
	
	public void createOrgWithType(String orgname)
	{
	orgTf.sendKeys(orgname);
	CreateOrganizationPage c=new CreateOrganizationPage(driver);
	c.selectIndustry();
	c.selectType();
	saveBtn.click();
	}
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryInTf;
	
	public WebElement getIndustryInTf() {
		return industryInTf;
	}


	public WebElement getTypeInTf() {
		return TypeInTf;
	}

    @FindBy(id="mouseArea_Type")
	private WebElement TypeInTf;
    
	public void verifyingIndustry(String expectedIndustry)
	{
	String actualIndustry = industryInTf.getText();
	if (actualIndustry.equals(expectedIndustry)) {
	System.out.println("expectedIndustry in textfield verified ");
	} else {
	System.out.println("expectedIndustry in textfield not verified");
	}
	//Assert.assertEquals(actualIndustry, expectedIndustry);
	}
	
	public void verifyingType(String expectedType)
	{
	String actualType = TypeInTf.getText();
	if (actualType.trim().equals(expectedType)) {
	System.out.println("expectedType in textfield verified ");
	} else {
	System.out.println("expectedType in textfield not verified");
	}
	//Assert.assertEquals(actualType, expectedType);
	}

}
