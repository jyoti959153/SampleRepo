package ContactModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertyfileUtility;
import com.crm.generic.objectrepositoryutility.ContactInformationPage;
import com.crm.generic.objectrepositoryutility.ContactsPage;
import com.crm.generic.objectrepositoryutility.CreateContactsPage;
import com.crm.generic.objectrepositoryutility.CreateOrganizationPage;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.LoginPage;
import com.crm.generic.objectrepositoryutility.LogoutPage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactByPOM {
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
//browser actions
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

//login 
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(url, username, password);
//creating the contact
		HomePage hp = new HomePage(driver);
		hp.getContactLink1().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactsLink2().click();
		cp.getCreateconIcon().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContact(contactName);
//verify the contact in header
		ccp.verifyingInHeader(contactName);
//verifying contactname in lastname textfield
		ccp.verifyingInTf(contactName);
//logout
		LogoutPage lo = new LogoutPage(driver);
		lo.logout();

	}
}
