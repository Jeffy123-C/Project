package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(name="username") WebElement usernamefield;
	@FindBy(name="password") WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']") WebElement signinbutton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement signintitle;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;//chaining of pages
		
	}
	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}
	public HomePage clickOnSignInButton() {
		signinbutton.click();
		return new HomePage(driver);
	}
	public boolean dashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public String getPageTitle() {
		return title.getText();
		
	}
	public String getSignInTitle() {
		return signintitle.getText();
	}
	}


