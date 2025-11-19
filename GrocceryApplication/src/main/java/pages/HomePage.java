package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		public WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
			
		}
		@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminbutton;
		@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logoutbutton;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminmoreinfolink;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement newsmoreinfolink;
		@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
		
		

		

		public void clickOnAdminButton() {
			adminbutton.click();
			
			
		}
		public void clickOnLogoutButton() {
			logoutbutton.click();
		
		}


		public void clickOnMoreInfoLink() {
			adminmoreinfolink.click();
		}
		public void clickOnNewsMoreInfoLink() {
			newsmoreinfolink.click();
		}
		public boolean titleDisplayed() {
			return title.isDisplayed();
		}
}



