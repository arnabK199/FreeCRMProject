package com.ak.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ak.base.BaseTest;

import io.qameta.allure.Step;

public class LoginPage extends BaseTest{
	
	public LoginPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".btn.btn-primary.btn-xs-2.btn-shadow.btn-rect.btn-icon.btn-icon-left")
	public WebElement logInBtn;
	
	@FindBy(linkText="your business cloud partner ")
	public WebElement crmLogo;
	
	@FindBy(linkText="Sign Up")
	public WebElement signUpLink;
	
	@FindBy(name="email")
	public WebElement emailField;
	
	@FindBy(name="password")
	public WebElement passWordField;
	
	@FindBy(css=".ui.fluid.large.blue.submit.button")
	public WebElement submitBtn;
	
	@Step("Validate the Title of the Login Page Step")
	public String validateTitle() {
		return driver.getTitle();
	}
	
	@Step("Validate the CRM Logo of the Login Page Step")
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	@Step("Validate the Login Funtionality with ID: {0} and Password: {1} Step")
	public HomePage doLogin(String userName, String pwd) throws FileNotFoundException {
		logInBtn.click();
		emailField.sendKeys(userName);
		passWordField.sendKeys(pwd);
		submitBtn.click();
		
		return new HomePage();
	}

}
