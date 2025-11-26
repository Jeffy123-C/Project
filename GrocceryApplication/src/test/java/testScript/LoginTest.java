package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;
	@Test(priority=1,description="verifying successful user login with valid credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();//chaining of methods
		boolean isDashboardDisplayed=loginpage.dashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed,Constant.ValidCredentialErrorMessage);
		
	}
	@Test(priority=2,description="verifying user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.InvalidUsernameErrorMessage);
		
	}
	@Test(priority=3,description="verifying user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);		
		homepage=loginpage.clickOnSignInButton();
		String actual=loginpage.getSignInTitle();
		String expected="Sign in to start your session";
		Assert.assertEquals(actual, expected,Constant.InvalidPasswordErrorMessage);
		
	}
	@Test(priority=4,description="verifying user login with invalid credentials",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String username,String password) throws IOException {
		//String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.InvalidCredentialErrorMessage);
		
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}



	

