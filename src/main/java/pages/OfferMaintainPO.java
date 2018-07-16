package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.CommonPageUI;
import interfaces.OfferMaintainPageUI;

public class OfferMaintainPO extends AbstractPage{
	WebDriver driver;
	
	public OfferMaintainPO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickOnSearchIcon() {
		waitForControlVisible(driver, OfferMaintainPageUI.SEARCH_ICON);
		clickToElement(driver, OfferMaintainPageUI.SEARCH_ICON);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}
	
	
	
	
	
	

}
