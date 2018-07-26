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

public class OfferMaintainPageSteps extends AbstractPage {
	WebDriver driver;
	//private LoginPagePO loginPage;
	private OfferMaintainPO offerMaintainPage;
	String username, password;

	public OfferMaintainPageSteps() {
		driver = Hooks.openBrowser();
		PageFactoryManager.getCommonPage(driver);
		offerMaintainPage = PageFactoryManager.getOfferMaintainPage(driver);
		PageFactoryManager.getAbstractTestPage(driver);

	}
	
	/*@Then("^I verify expected data at \"(.*?)\" textbox with actual data \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		String actualValue1 = ShareData.value;
		abstractTest.verifyEquals(actualValue1, expectedValue);
	}*/
	
	
	
	@When("^I click on Search icon$")
	public void iClickOnSearchIcon() {
		offerMaintainPage.clickOnSearchIcon();
	}

	

}
