package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
@FindBy(id="news") WebElement newsfield;
@FindBy(name="create") WebElement savebutton;
@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
@FindBy(name="un") WebElement searchfield;
@FindBy(name="Search") WebElement searchbutton1;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmessage;


public ManageNewsPage clickOnNewButton() {
	newbutton.click();
	return this;
}
public ManageNewsPage enterNewsOnNewsField(String news) {
	newsfield.sendKeys(news);
	return this;
}
public ManageNewsPage clickOnSaveButton() {
	savebutton.click();
	return this;
}
public ManageNewsPage clickOnSearchButton() {
	searchbutton.click();
	return this;
	
}
public ManageNewsPage enterNewsOnSearchField(String news) {
	searchfield.sendKeys(news);	
	return this;
}
public ManageNewsPage clickOnSearchButton1() {
	searchbutton1.click();
	return this;
	
}
public boolean successfullalertmessageDisplayed() {
	return alertmessage.isDisplayed();
}
public boolean isSearchedUserDisplayed() {
	return searchbutton1.isDisplayed();
}



}
