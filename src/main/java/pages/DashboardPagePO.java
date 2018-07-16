package pages;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DashboardPagePO extends AbstractPage{
	WebDriver driver;
	
	public DashboardPagePO(WebDriver driver_) {
		this.driver = driver_;
		
	}
	
	/*public boolean isDashboardPageShowed() {
		waitForControlVisible(driver, DashboardPageUI.DASH_PAGE_LINK);
		return isControlDisplayed(driver, DashboardPageUI.DASH_PAGE_LINK);
	}*/

}
