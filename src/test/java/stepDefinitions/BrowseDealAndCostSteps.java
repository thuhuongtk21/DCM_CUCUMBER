package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.BrowseDealAndCostPagePO;
import pages.CommonPagePO;
import pages.OfferCreatePO;
import pages.PageFactoryManager;

public class BrowseDealAndCostSteps {
	WebDriver driver;
	private BrowseDealAndCostPagePO browseDealAndCostPage;

	public BrowseDealAndCostSteps() {
		driver = Hooks.openBrowser();
		browseDealAndCostPage = PageFactoryManager.getBrowseDealAndCostPage(driver);
	}
	
	@When("^I click on \"(.*?)\" tab$")
	public void iClickOnDynamicTab(String value) {
	    browseDealAndCostPage.openDynamicTab(value);
	}

}
