package BaseClass;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.generic.databaseutility.DatabaseUtility;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertyfileUtility;
import com.crm.generic.objectrepositoryutility.LoginPage;
import com.crm.generic.objectrepositoryutility.LogoutPage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class BaseTest {
	public WebDriver driver;
    public static WebDriver sdriver;
	public DatabaseUtility du=new DatabaseUtility();
	public PropertyfileUtility pu=new PropertyfileUtility();
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	public WebDriverUtility wdu=new WebDriverUtility();

	@BeforeSuite(groups={"SmokeTest","RegressionTest"})
	public void ConfigBS() throws SQLException
	{
	System.out.println("connect to database");
	du.connectToDatabase1();
	}
	
	@BeforeTest
	public void configBT()
    {
    System.out.println("After Test");
    }
	
	
	//@Parameters("Browser")
	@BeforeClass(groups={"SmokeTest","RegressionTest"})
	public void ConfigBC() throws Exception
	{
	System.out.println("launch the browser");
	String BROWSER = pu.getDataFromPropertyfile("browser");
	//String BROWSER = browser;
	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	sdriver=driver;  
	}
	
	@BeforeMethod(groups={"SmokeTest","RegressionTest"})
	public void ConfigBM() throws Exception
	{
	System.out.println("login t o application");
	String url = pu.getDataFromPropertyfile("url");
	String username = pu.getDataFromPropertyfile("username");
	String password = pu.getDataFromPropertyfile("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginTOApp(url, username, password);
	}
	
	@AfterMethod(groups={"SmokeTest","RegressionTest"})
	public void ConfigAM() throws InterruptedException
	{
	System.out.println("logout from application");
	LogoutPage lo=new LogoutPage(driver);
	lo.logout();
	}
	
    @AfterClass(groups={"SmokeTest","RegressionTest"})
    public void ConfigAC() throws InterruptedException
	{
	System.out.println("close the browser");
	Thread.sleep(2000);
	driver.quit();
	}
    @AfterTest
    public void configAT()
    {
    System.out.println("After Test");
    }
    @AfterSuite(groups={"SmokeTest","RegressionTest"})
    public void ConfigAS()
	{
	System.out.println("close database");
	du.colseConnection();
	}

}
