package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.BrowseDealAndCostPageUI;
import interfaces.CommonPageUI;

public class BrowseDealAndCostPagePO extends AbstractPage{
	WebDriver driver;
	
	public BrowseDealAndCostPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void openDynamicTab(String value) {
		waitForControlVisible(driver, BrowseDealAndCostPageUI.DYNAMIC_TAB, value);
		clickToElement(driver, BrowseDealAndCostPageUI.DYNAMIC_TAB, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

}
