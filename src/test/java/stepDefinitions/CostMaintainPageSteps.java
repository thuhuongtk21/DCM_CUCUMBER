package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import commons.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.LoginPagePO;
import pages.OfferMaintainPO;
import pages.PageFactoryManager;

public class CostMaintainPageSteps extends AbstractPage {
	WebDriver driver;
	private CommonPagePO commonPage;
	private AbstractTest abstractTest;
	//private LoginPagePO loginPage;
	private OfferMaintainPO offerMaintainPage;
	String username, password;

	public CostMaintainPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		offerMaintainPage = PageFactoryManager.getOfferMaintainPage(driver);
		abstractTest = PageFactoryManager.getAbstractTestPage(driver);

	}
	
	@Given("^I select \"(.*?)\" in drop-down list$")
	public void iClickOnDynamicDropDownTextBox(String value) throws Exception {
		commonPage.selectDynamicValueFromDropdownList(value);
		Thread.sleep(5000);

	}

	

}
