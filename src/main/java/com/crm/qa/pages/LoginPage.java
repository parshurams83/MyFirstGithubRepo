package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - OR
	
	@FindBy(name="username")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submitButton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement LogoffButton;
	
	
	//Initialise the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	public String ValidatePageTitle() {
		
		String pagetitle= driver.getTitle();
		System.out.println(pagetitle);
		return pagetitle;
		
	}
	
	public HomePage Login(String un, String ps) {
		name.sendKeys(un);
		password.sendKeys(ps);
		submitButton.click();
		
		return new HomePage();
		
	}
	
	
}
