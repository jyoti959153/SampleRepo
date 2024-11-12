package ContactModule;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertyfileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgName {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
//creating the obj for utility classes so that we can get methods 
		PropertyfileUtility pu = new PropertyfileUtility();
		ExcelUtility ex = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wdu = new WebDriverUtility();

//getting the data from property file
		String browser = pu.getDataFromPropertyfile("browser");
		String url = pu.getDataFromPropertyfile("url");
		String username = pu.getDataFromPropertyfile("username");
		String password = pu.getDataFromPropertyfile("password");

//getting the data from excel file and get the random number
		String orgName = ex.getDataFromExcel("org", 1, 3).toString() + ju.getRandomNumber();
		System.out.println(orgName);
		String contactName = ex.getDataFromExcel("con", 1, 3).toString() + ju.getRandomNumber();
		System.out.println(contactName);
//browser actions
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);
//login 
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
//creating the organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
//creating the contact
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.linkText("Contacts"))).perform();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();

//switching the driver control to childwindow

		Set<String> windowids = driver.getWindowHandles();
		for (String wid : windowids) {
			String actualUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (actualUrl.contains("Accounts&action")) {
				driver.findElement(By.name("search_text")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
			}
		}
//parent window
		for (String wid : windowids) {
			String parentUrl = driver.switchTo().window(wid).getCurrentUrl();

			if (parentUrl.contains("Contacts&action")) {
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			}
		}

//verify the contact in header

		String actualContact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		/*if (actualContact.contains(contactName)) {
			System.out.println("contactname in header is  verified ");
		} else {
			System.out.println("contactname in header  is not verified");
		}*/
		boolean act1 = actualContact.contains(contactName);
		Assert.assertEquals(act1, true, "contact not verified in header");
		System.out.println("verified contact in header");
//verifying contactname in lastname textfield
		String actualContact2 = driver.findElement(By.id("mouseArea_Last Name")).getText();
		/*if (actualContact2.contains(contactName)) {
			System.out.println("contactname in textfield is verified ");
		} else {

			System.out.println("contactname in textfield is not verified");
		}*/
		boolean act2 = actualContact2.contains(contactName);
		Assert.assertEquals(act2, true, "contact not verified in textfield");
		System.out.println("verified contact in textfield");
		// driver.quit();

	}
}