package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description="verifying user able to add new news")
	public void verifyUserIsAbleToAddNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage=new HomePage(driver);
		managenewspage=homepage.clickOnNewsMoreInfoLink();
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		String news=ExcelUtility.getStringData(0, 0, "NewsPage");
		managenewspage.clickOnNewButton().enterNewsOnNewsField(news).clickOnSaveButton();
	
		
	    
	    boolean isSuccessfullMessageDisplayed=managenewspage.successfullalertmessageDisplayed();
		Assert.assertTrue(isSuccessfullMessageDisplayed,Constant.AddingNewsErrorMessage);
						
}
	@Test(description="verifying user able to search the news")
	public void verifyUserIsAbleToSearch() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage=new HomePage(driver);
		managenewspage=homepage.clickOnNewsMoreInfoLink();
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		String news=ExcelUtility.getStringData(0, 0, "NewsPage");
		managenewspage.clickOnSearchButton().enterNewsOnSearchField(news).clickOnSearchButton1();
		
		
		boolean issearchbuttondisplayed=managenewspage.isSearchedUserDisplayed();
		Assert.assertTrue(issearchbuttondisplayed,Constant.SearchingNewsErrorMessage);
		
	
}
}
