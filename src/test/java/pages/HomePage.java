package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBox;
	
	@FindBy(css = ".input-group-btn")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public void searchItem(String itemName) {
		searchBox.sendKeys(itemName);
		searchBtn.click();
	}
	public String isHomePage() {
		
		return driver.getTitle();
	}
}
