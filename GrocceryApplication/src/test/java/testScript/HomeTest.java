package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(description="verifying user can sucessfully logout",retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLogout() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminButton();
		loginpage=homepage.clickOnLogoutButton();
		boolean isTitleDisplayed=homepage.titleDisplayed();
		Assert.assertTrue(isTitleDisplayed,Constant.LogoutErrorMessage);
				
		
	}
	

}

