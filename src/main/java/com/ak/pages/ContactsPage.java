package com.ak.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ak.base.BaseTest;

public class ContactsPage extends BaseTest{

	public ContactsPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ui.header.item.mb5.light-black")
	public WebElement contactsLabel;
	
	@FindBy(xpath="//div[@class='ui warning message']/div/span")
	public WebElement recordsWarning;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	public WebElement newContactBtn;
	
	@FindBy(name="first_name")
	public WebElement firstName;
	
	@FindBy(name="last_name")
	public WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	public WebElement company;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement contactSaveBtn;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	public List<WebElement> contactNames;
	
	
	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public String validateRecordsWarning() {
		return recordsWarning.getText();
	}
	
	public void validateNewContact(String fn , String ln , String comp) {
		newContactBtn.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		company.sendKeys(comp);
		contactSaveBtn.click();
	}
	
	public boolean validateAddedContact(String name) {
		
		int tableSize=  contactNames.size();
		for(int i=1; i<tableSize ; i++) {
			if(contactNames.get(i).getText().contains(name)) {
				return true;
			}
		}
		return false;
		
	}
	
	

}
