package com.ak.testCases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ak.base.BaseTest;
import com.ak.pages.ContactsPage;
import com.ak.pages.HomePage;
import com.ak.pages.LoginPage;

public class HomePageTest extends BaseTest{
	
	public LoginPage lp;
	public HomePage hp;
	public ContactsPage cp;
	
	public HomePageTest() throws FileNotFoundException {
		
	}
	
	@BeforeMethod
	public void init() throws FileNotFoundException {
		BaseTest.initConfig();
		lp = new LoginPage();
		hp =lp.doLogin("arnabkundu.ary96@gmail.com", "kVMrmyJuughz9@G");
	}
	
	@Test
	public void homePageTitleTest() {
		String title =hp.validateHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test
	public void homePageNameLabelTest() {
		Assert.assertTrue(hp.validateNameLabel());
	}
	
	@Test
	public void homePageContactsLinkTest() throws FileNotFoundException {
		cp=hp.goToContactsPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
