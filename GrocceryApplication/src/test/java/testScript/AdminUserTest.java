package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base{
	@Test
	
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
						
	}
	
@Test
	
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
								
	}
@Test

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
	
							
}
}
