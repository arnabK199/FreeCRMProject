package com.ak.testCases;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ak.base.BaseTest;
import com.ak.pages.ContactsPage;
import com.ak.pages.HomePage;
import com.ak.pages.LoginPage;
import com.ak.utils.TestUtils;

public class ContactsPageTest extends BaseTest{
	
	public LoginPage lp;
	public HomePage hp;
	public ContactsPage cp;

	public ContactsPageTest() throws FileNotFoundException {
		
	}
	
	@BeforeMethod
	public void init() throws FileNotFoundException, InterruptedException {
		BaseTest.initConfig();
		lp = new LoginPage();
		hp=lp.doLogin("arnabkundu.ary96@gmail.com", "kVMrmyJuughz9@G");
		cp=hp.goToContactsPage();
		Thread.sleep(2000);
	}
	
	@Test(priority =4)
	public void ContactsPageValidateContactsLabel() {
		Assert.assertTrue(cp.validateContactsLabel());
	}
	
	@Test(priority =3)
	public void ContactsPagevalidateRecordsWarning() {
		String warning = cp.validateRecordsWarning();
		Assert.assertFalse(warning.contains("No records found"));
	}
	
	@Test(priority =1 ,dataProvider="getData")
	public void ContactsPagevalidateNewContact(Hashtable<String,String> data) {
		cp.validateNewContact(data.get("firstname"), data.get("lastname"), data.get("company"));
	}
	
	@Test(priority =2 ,dataProvider="getData")
	public void validateContactsadded(Hashtable<String,String> data) {
		if(cp.validateAddedContact(data.get("firstname"))) {
			System.out.println(data.get("fistname")+"contact successfully added");
		}else {
			System.out.println(data.get("fistname")+"contact not added");
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = TestUtils.getTestData("contact");
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
