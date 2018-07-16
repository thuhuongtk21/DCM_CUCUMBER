package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DealBuilderPageUI;

public class DealBuilderPO extends AbstractPage{
	WebDriver driver;
	
	public DealBuilderPO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void selectDealType(String value) {
		waitForControlVisible(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE, value);
		clickToElement(driver, DealBuilderPageUI.DYNAMIC_DEAL_TYPE, value);
	}

}
