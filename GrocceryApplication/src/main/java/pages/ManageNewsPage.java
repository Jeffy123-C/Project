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


public void clickOnNewButton() {
	newbutton.click();
}
public void enterNewsOnNewsField(String news) {
	newsfield.sendKeys(news);			
}
public void clickOnSaveButton() {
	savebutton.click();
}
public void clickOnSearchButton() {
	searchbutton.click();
	
}
public void enterNewsOnSearchField(String news) {
	searchfield.sendKeys(news);		
}
public void clickOnSearchButton1() {
	searchbutton1.click();
	
}
public boolean successfullalertmessageDisplayed() {
	return alertmessage.isDisplayed();
}
public boolean isSearchedUserDisplayed() {
	return searchbutton1.isDisplayed();
}



}
