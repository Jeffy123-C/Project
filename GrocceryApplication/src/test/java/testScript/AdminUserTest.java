package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base{
	@Test(description="verifying user able to add new admin user")
	
	public void verifyUserIsAbleToAddNewAdminUser() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreInfoLink();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickOnNewButton();
		FakerUtility faker=new FakerUtility();		
		String username1=faker.createRandomUsername();
		String password1=faker.createRandomPassword();
		//String username1=ExcelUtility.getStringData(0, 0, "AdminPage");
		//String password1=ExcelUtility.getStringData(0, 1, "AdminPage");
		adminpage.enterUsernameOnUsernameField(username1);
		adminpage.enterPasswordOnPasswordField(password1);
		adminpage.selectUserType();
		adminpage.clickOnSaveButton();
		boolean isAlertDisplayed=adminpage.isSuccessfullAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constant.AddingNewUserErrorMessage);
				
						
	}
	
@Test(description="verifying user able to search the newly added user")
	
	public void verifyUserIsAbleToSearchNewAddedUser() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreInfoLink();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickOnSearchButton();
		String username1=ExcelUtility.getStringData(0, 0, "AdminPage");		
		adminpage.enterUsernameOnSearchUsernameField(username1);
		adminpage.selectUserTypedropdown();		
		adminpage.clickOnSearchButton1();
		boolean isNewUserSearched=adminpage.isSearchedUserDisplayed();
		Assert.assertTrue(isNewUserSearched,Constant.SearchingNewUserErrorMessage);
				
						
								
	}
@Test(description="verifying user able to reset the user info")

public void verifyUserIsAbleToResetUsersInfo() throws IOException {
	String username=ExcelUtility.getStringData(0, 0, "LoginPage");
	String password=ExcelUtility.getStringData(0, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickOnSignInButton();
	HomePage homepage=new HomePage(driver);
	homepage.clickOnMoreInfoLink();
	AdminPage adminpage=new AdminPage(driver);
	adminpage.clickOnResetButton();
	boolean isResetButtonDisplayed=adminpage.isResetButtonDisplayed();
	Assert.assertTrue(isResetButtonDisplayed,Constant.ResetUserErrorMessage);
	
							
}
}
