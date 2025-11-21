package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description="verifying user able to add new news")
	public void verifyUserIsAbleToAddNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnNewsMoreInfoLink();
		ManageNewsPage newspage=new ManageNewsPage(driver);
		newspage.clickOnNewButton();
		String news=ExcelUtility.getStringData(0, 0, "NewsPage");
		newspage.enterNewsOnNewsField(news);
	    newspage.clickOnSaveButton();
	    boolean isSuccessfullMessageDisplayed=newspage.successfullalertmessageDisplayed();
		Assert.assertTrue(isSuccessfullMessageDisplayed,"user unable to add news");
						
}
	@Test(description="verifying user able to search the news")
	public void verifyUserIsAbleToSearch() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnNewsMoreInfoLink();
		ManageNewsPage newspage=new ManageNewsPage(driver);
		newspage.clickOnSearchButton();
		String news=ExcelUtility.getStringData(0, 0, "NewsPage");
		newspage.enterNewsOnSearchField(news);
		newspage.clickOnSearchButton1();
		boolean issearchbuttondisplayed=newspage.isSearchedUserDisplayed();
		Assert.assertTrue(issearchbuttondisplayed,"user nable to search the news");
		
	
}
}
