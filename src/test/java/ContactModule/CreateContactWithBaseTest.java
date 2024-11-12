package ContactModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.objectrepositoryutility.ContactsPage;
import com.crm.generic.objectrepositoryutility.CreateContactsPage;
import com.crm.generic.objectrepositoryutility.CreateOrganizationPage;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.OrganizationPage;

import BaseClass.BaseTest;
@Listeners(com.crm.generic.listenerutility.ListenerImplementationClass.class)
public class CreateContactWithBaseTest extends BaseTest {
	@Test(groups="SmokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		// getting the data from excel file and get the random number
		String contactName = eu.getDataFromExcel("con", 1, 3).toString() + ju.getRandomNumber();
		// creating the contact
		HomePage hp = new HomePage(driver);
		hp.getContactLink1().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactsLink2().click();
		cp.getCreateconIcon().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContact(contactName);
		// verify the contact in header
		ccp.verifyingInHeader(contactName);
		// verifying contactname in lastname textfield
		ccp.verifyingInTf(contactName);
	}

	@Test(groups="RegressionTest")
	public void crateContactWithSupportdate() throws EncryptedDocumentException, IOException {
		// getting the data from excel file and get the random number
		String contactName = eu.getDataFromExcel("con", 1, 3).toString() + ju.getRandomNumber();
		String startdate = ju.getSystemDateYYYYDDMM().toString();
		String enddate = ju.getRequiredDateYYYYDDMM(30).toString();
		// creating the contact
		HomePage hp = new HomePage(driver);
		hp.getContactLink1().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactsLink2().click();
		cp.getCreateconIcon().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContactWithSupportdate(contactName, startdate, enddate);
		// verify the contact in header
		ccp.verifyingInHeader(contactName);
		// verifying contactname in lastname textfield
		ccp.verifyingInTf(contactName);
	}

	@Test(groups="RegressionTest")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException {
		// getting the data from excel file and get the random number
		String orgName = eu.getDataFromExcel("org", 1, 3).toString() + ju.getRandomNumber();
		String contactName = eu.getDataFromExcel("con", 1, 3).toString() + ju.getRandomNumber();
		// creating the organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink1().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrgLink2().click();
		op.getCreateOrgIcon().click();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrgTf().sendKeys(contactName);
		cop.getSaveBtn().click();
	}

}
