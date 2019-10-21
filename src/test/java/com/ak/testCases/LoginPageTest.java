package com.ak.testCases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ak.base.BaseTest;
import com.ak.pages.HomePage;
import com.ak.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	public LoginPage lp;
	public static HomePage hp;
	
	public LoginPageTest() throws FileNotFoundException {
		
	}

	@BeforeMethod
	public void init() throws FileNotFoundException {
		BaseTest.initConfig();
		lp = new LoginPage();
		}
	
	@Test
	public void loginPageTitleTest() {
		String title =lp.validateTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	/*@Test
	public void loginPageLogoTest() {
		Assert.assertTrue(lp.validateCRMLogo());
	} */
	
	@Test
	public void loginTest() throws FileNotFoundException {
		hp = lp.doLogin("arnabkundu.ary96@gmail.com", "kVMrmyJuughz9@G");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
