package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Autohealing 
{
//@findAll internally it uses or condition if any one condition is correct then it will continue the execution 
@FindAll({@FindBy(name="user_name"),@FindBy(xpath="//input[@type='text']")})
WebElement usernameTf;

//@findbys internally it uses and condition if any one condition is wrong then it will not continue the execution
//@findBys({@FindBy(name="user_name"),@FindBy(xpath="//input[@type='text']")})
WebElement passwordTf;



}
