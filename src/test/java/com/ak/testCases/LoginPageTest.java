package com.ak.testCases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ak.base.BaseTest;
import com.ak.pages.HomePage;
import com.ak.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


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
	
	@Test(description = "This is  test to validate the title of the Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("This is the Test case to validate the Title of the Page")
	@Story("Story Name: Validate the Title")
	public void loginPageTitleTest() {
		String title =lp.validateTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	/*@Test
	public void loginPageLogoTest() {
		Assert.assertTrue(lp.validateCRMLogo());
	} */
	
	
	@Test(description = "This is  test to validate the Login Functionality of the Login Page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This is the Test case to validate the Login Functionality of the Login Page")
	@Story("Story Name: Validate the Login Functionality of the Login Page")
	public void loginTest() throws FileNotFoundException {
		hp = lp.doLogin("arnabkundu.ary96@gmail.com", "kVMrmyJuughz9@G");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
