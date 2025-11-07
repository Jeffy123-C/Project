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
		

		public void clickOnAdminButton() {
			adminbutton.click();
			
			
		}
		public void clickOnLogoutButton() {
			logoutbutton.click();
		
		}
}



