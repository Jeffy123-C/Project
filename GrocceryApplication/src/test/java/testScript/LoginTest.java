package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority=1,description="verifying successful user login with valid credentials")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		boolean isDashboardDisplayed=loginpage.dashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed,"user was unable to login with valid credentials");
		
	}
	@Test(priority=2,description="verifying user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"user was able to login with invalid username");
		
	}
	@Test(priority=3,description="verifying user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		
		loginpage.clickOnSignInButton();
		
	}
	@Test(priority=4,description="verifying user login with invalid credentials")
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		boolean isDashboardDisplayed=loginpage.dashboardDisplayed();
		Assert.assertFalse(isDashboardDisplayed, "user is able to login with valid credentials");
	}


}

