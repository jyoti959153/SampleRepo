package ContactModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertyfileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDate {
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
		String contactName = ex.getDataFromExcel("con", 1, 3).toString() + ju.getRandomNumber();

//getting sytemdate(startdate)
		String startDate = ju.getSystemDateYYYYDDMM();
		System.out.println(startDate);
//getting date after 30 days
		String endDate = ju.getRequiredDateYYYYDDMM(30);
		System.out.println(endDate);
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
//creating the contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.id("jscal_field_support_start_date")).clear();
		driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(startDate);
		driver.findElement(By.id("jscal_field_support_end_date")).clear();
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(endDate);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//verify the contact in header
		Thread.sleep(5000);
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
		Assert.assertEquals(act2, true, "contact not verified in header");
		System.out.println("verified contact in header");
		driver.quit();

	}
}
