package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	
		public WebDriver driver;
		WaitUtility waitutility=new WaitUtility();
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
			
		}
		@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminbutton;
		@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logoutbutton;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminmoreinfolink;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement newsmoreinfolink;
		@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
		
		

		

		public HomePage clickOnAdminButton() {
			waitutility.waitUntilElementToBeClickable(driver, adminbutton);
			adminbutton.click();
			return this;
			
			
		}
		public LoginPage clickOnLogoutButton() {
			logoutbutton.click();
			return new LoginPage(driver);
		
		}


		public AdminPage clickOnMoreInfoLink() {
			adminmoreinfolink.click();
			return new AdminPage(driver);
		}
		public ManageNewsPage clickOnNewsMoreInfoLink() {
			newsmoreinfolink.click();
			return new ManageNewsPage(driver);
		}
		public boolean titleDisplayed() {
			return title.isDisplayed();
		}
}



