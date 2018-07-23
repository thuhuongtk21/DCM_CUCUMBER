package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.CommonPageUI;
import interfaces.DealBuilderPageUI;

public class DealBuilderPagePO extends AbstractPage{
	WebDriver driver;
	
	public DealBuilderPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickOnADealType(String value) {
		waitForControlVisible(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE_AND_LEVEL, value);
		clickToElement(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE_AND_LEVEL, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}
	
	public void clickOnASubDealType(String value) {
		waitForControlVisible(driver, DealBuilderPageUI.DYNAMIC_DEAL_SUB_TYPE, value);
		clickToElement(driver, DealBuilderPageUI.DYNAMIC_DEAL_SUB_TYPE, value);
	}
	public void clickOnALevel(String value) {
		waitForControlVisible(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE_AND_LEVEL, value);
		clickToElement(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE_AND_LEVEL, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

}
