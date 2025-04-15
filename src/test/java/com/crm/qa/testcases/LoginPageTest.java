package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPage loginpage;
	public HomePage homePage;
	
	LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		Initialise();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority= 1)
	public void LoginTitleTest() {
		
		String title = loginpage.ValidatePageTitle();
		Assert.assertEquals(title, "Test Login | Practice Test Automation");
	}
	
	
	@Test(priority= 2)
	public void ClickLoginButton() {
		homePage = loginpage.Login(prop.getProperty("uname"), prop.getProperty("pword"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}
