package com.crm.generic.webdriverutility;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void implicitylyWaitforWebPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void explicitlyWaitForWebElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void explicitlyWaitForWebElementToLoad2(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public void switchToNewWindowOnUrl(WebDriver driver, String partialUrl) {
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> it = windowids.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actualurl = driver.getCurrentUrl();
			if (actualurl.contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToNewWindowOnTitle(WebDriver driver, String partialTitle) {
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> it = windowids.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actualurl = driver.getTitle();
			if (actualurl.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrameOnIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameOnNameId(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrameOnWebelement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchtoAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchtoAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String switchtoAlertgetText(WebDriver driver) {
		String AlertText = driver.switchTo().alert().getText();
		return AlertText;
	}

	public void switchtoAlertsendData(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	public void selectBasedOnVisibleText(WebElement element, String text) {
		Select s1 = new Select(element);
		s1.selectByVisibleText(text);
	}

	public void selectBasedOnIndex(WebElement element, int index) {
		Select s2 = new Select(element);
		s2.selectByIndex(index);
	}

	public void selectBasedOnValue(WebElement element, String value) {
		Select s3 = new Select(element);
		s3.selectByValue(value);
	
	}
	
	public WebElement getfirstselectedOptionFromDropDown(WebElement element) {
		Select s4 = new Select(element);
		WebElement firstSelectedOption = s4.getFirstSelectedOption();
		return firstSelectedOption;
	}
	


	public void mouseMovement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement Srcelement, WebElement targetelement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(Srcelement, targetelement).perform();
	}
	
	public void movetocordiates(WebDriver driver, int x,int y) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(x, y).perform();
	}
	
	public void clickandhold(WebDriver driver,WebElement element ) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}
	
	public String gettheTitle(WebDriver driver)
	{
	String title = driver.getTitle();
	return title;
	}
	
	
	
	public void takeScreenshotofWebpage(WebDriver driver) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File perm=new File("./screenshot.shot.png");
	FileUtils.copyFile(temp, perm);
	}
	
	public void takeScreenshotofWebelement(WebElement element) throws IOException
	{
	File temp = element.getScreenshotAs(OutputType.FILE);
	File perm=new File("./screenshot.shot.png");
	FileUtils.copyFile(temp, perm);
	}
	
	public void closethewindow(WebDriver driver)
	{
	driver.close();
	}
	
	public void closewindows(WebDriver driver)
	{
	driver.quit();
	}
	
	public void precondition(WebDriver driver,String  url)
	{
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

}
