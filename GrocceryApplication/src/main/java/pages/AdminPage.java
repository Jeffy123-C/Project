package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(id="username") WebElement usernamefield;
	@FindBy(id="password") WebElement passwordfield;
	@FindBy(id="user_type") WebElement usertypedropdown;
	@FindBy(name="Create") WebElement savebutton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
	@FindBy(name="un") WebElement searchusernamefield;
	@FindBy(name="ut") WebElement dropdown;
	@FindBy(name="Search") WebElement searchbutton1;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessage;
@FindBy(xpath="//td[text()='jeffy']") WebElement searchuser;
	
	public AdminPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	public AdminPage enterUsernameOnUsernameField(String username1) {
		usernamefield.sendKeys(username1);	
		return this;
	}
	public AdminPage enterPasswordOnPasswordField(String password1) {
		passwordfield.sendKeys(password1);
		return this;
	}
	public AdminPage selectUserType() {
		pageutility.selectDropdownWithIndex(usertypedropdown, 2);;
		//Select select=new Select(usertypedropdown);
		//select.selectByIndex(2);
		return this;
	}	
	public AdminPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}
	public AdminPage clickOnSearchButton() {
		searchbutton.click();
		return this;
		
	}
	public AdminPage enterUsernameOnSearchUsernameField(String username1) {
		searchusernamefield.sendKeys(username1);
		return this;
		
	}
	public AdminPage selectUserTypedropdown() {
		Select select=new Select(dropdown);
		select.selectByIndex(2);	
		return this;
	}
	public AdminPage clickOnSearchButton1() {
		searchbutton1.click();
		return this;
		
	}
	public AdminPage clickOnResetButton() {
		resetbutton.click();
		return this;
	}
	public boolean isSuccessfullAlertDisplayed() {
		return alertmessage.isDisplayed();
	}
	public boolean isDisplayed() {
		return alertmessage.isDisplayed();
	}
	public boolean isSearchedUserDisplayed() {
		return searchuser.isDisplayed();
	}
	public boolean isResetButtonDisplayed() {
		return resetbutton.isDisplayed();
	}

}
