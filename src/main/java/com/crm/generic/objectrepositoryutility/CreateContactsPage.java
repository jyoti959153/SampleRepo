package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutility.JavaUtility;

public class CreateContactsPage extends JavaUtility {
	WebDriver driver;
	
	public CreateContactsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameTf;

	public WebElement getLastnameTf() {
		return lastnameTf;
	}
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}
	
	public WebElement getStartDate() {
		return StartDate;
	}

	public void setStartDate(WebElement startDate) {
		StartDate = startDate;
	}


	@FindBy(name="support_start_date")
	private WebElement StartDate;
	
	
	public WebElement getEndDate() {
		return endDate;
	}

	public void setEndDate(WebElement endDate) {
		this.endDate = endDate;
	}
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement selectIcon;

	public WebElement getSelectIcon() {
		return selectIcon;
	}
	
	public void createContact(String contactname)
	{
	lastnameTf.sendKeys(contactname);
	saveBtn.click();
	}
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement contactInHeader;
	
	public WebElement getContactInHeader() {
		return contactInHeader;
	}

	public WebElement getContactInTf() {
		return contactInTf;
	}

	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(id="mouseArea_Last Name")
	private WebElement contactInTf;
	
	public void verifyingInHeader(String expectedcontactname)
	{
	String actual = contactInHeader.getText();
	if (actual.contains(expectedcontactname)) {
	System.out.println("expectedcontactname in header verified ");
	} else {
	System.out.println("expectedcontactname in header not verified");
	}
	//Assert.assertEquals(actual, expectedcontactname);
	}
	
	public void verifyingInTf(String expectedcontactname)
	{
	String actual = contactInTf.getText();
	if (actual.contains(expectedcontactname)) {
	System.out.println("expectedcontactname in textfield verified ");
	} else {
	System.out.println("expectedcontactname in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedcontactname);
	}
	
	public void createContactWithSupportdate(String contactname,String startdate,String enddate)
	{
	lastnameTf.sendKeys(contactname);
	StartDate.clear();
	StartDate.sendKeys(getSystemDateYYYYDDMM());
	endDate.clear();
    endDate.sendKeys(getRequiredDateYYYYDDMM(30));
    saveBtn.click();
	}
}
