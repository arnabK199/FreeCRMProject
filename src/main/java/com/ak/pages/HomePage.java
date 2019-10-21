package com.ak.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ak.base.BaseTest;

public class HomePage extends BaseTest{
	
	public HomePage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='user-display']")
	public WebElement nameLabel; 
	
	@FindBy(xpath="//div[@id='main-nav']/a[3]")
	public WebElement contactsLink; 
	
	@FindBy(xpath="//div[@id='main-nav']/a[5]")
	public WebElement dealsLink; 
	
	@FindBy(xpath="//div[@id='main-nav']/a[6]")
	public WebElement tasksLink; 
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateNameLabel() {
		return nameLabel.isDisplayed();
	}
	
	public ContactsPage goToContactsPage() throws FileNotFoundException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage goToDealsPage() throws FileNotFoundException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage goToTasksPage() throws FileNotFoundException {
		tasksLink.click();
		return new TasksPage();
	}
	

}
