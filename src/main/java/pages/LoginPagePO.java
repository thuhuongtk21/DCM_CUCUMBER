package pages;

import org.openqa.selenium.WebDriver;


import commons.AbstractPage;
import commons.Constant;
import pages.DashboardPagePO;
import interfaces.DashboardPageUI;
import interfaces.LoginPageUI;

public class LoginPagePO extends AbstractPage{
	WebDriver driver;
	private DashboardPagePO dashboardPage;
	

	//Constructor
	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputToUsername() {
		waitForControlVisible(driver, LoginPageUI.USERNAME_TXT);
		sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, Constant.USERNAME);
	}
	
	public void inputToPassword() {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, Constant.PASSWORD);
	}
	
	public void clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}
	
	public DashboardPagePO loginToApplication() {
		inputToUsername();
		inputToPassword();
		clickToLoginButton();
		waitForControlVisible(driver, DashboardPageUI.DASH_PAGE_LINK);
		return PageFactoryManager.getDashboardPage(driver);
	  }

}
