package ContactModule;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertyfileUtility;
import com.crm.generic.objectrepositoryutility.ContactsPage;
import com.crm.generic.objectrepositoryutility.CreateContactsPage;
import com.crm.generic.objectrepositoryutility.CreateOrganizationPage;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.LoginPage;
import com.crm.generic.objectrepositoryutility.OrganizationPage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgByPOM {
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
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(url, username, password);
//creating the organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink1().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrgLink2().click();
		op.getCreateOrgIcon().click();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrgTf().sendKeys(orgName);
		cop.getSaveBtn().click();
//creating the contact
		ContactsPage cp = new ContactsPage(driver);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.linkText("Contacts"))).perform();
		cp.getCreateconIcon().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.getLastnameTf().sendKeys(contactName);
		ccp.getSelectIcon().click();
        //switching the driver control to childwindow
		Set<String> windowids = driver.getWindowHandles();
		for (String wid : windowids) {
		String actualUrl = driver.switchTo().window(wid).getCurrentUrl();
		if (actualUrl.contains("Accounts&action")) {
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		  }
		}
		//parent window
		 for (String wid : windowids) {
		 String parentUrl = driver.switchTo().window(wid).getCurrentUrl();
		 if (parentUrl.contains("Contacts&action"))
		{
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		}
//verify the contact in header
        String actualContact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (actualContact.contains(contactName)) {
			System.out.println("contactname in header is  verified ");
		} else {
			System.out.println("contactname in header  is not verified");
		}
//verifying contactname in lastname textfield
		String actualContact2 = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if (actualContact2.contains(contactName)) {
			System.out.println("contactname in textfield is verified ");
		} else {

			System.out.println("contactname in textfield is not verified");
		}
		// driver.quit();

	}
}
}
