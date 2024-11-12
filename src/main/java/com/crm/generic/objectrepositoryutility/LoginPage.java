package com.crm.generic.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTf;
	
	public WebElement getUsernameTf() {
		return usernameTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy(name="user_password")
	private WebElement passwordTf;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public void loginTOApp(String url,String username,String password)
	{
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	usernameTf.sendKeys(username);
	passwordTf.sendKeys(password);
	loginBtn.click();
	}

}
