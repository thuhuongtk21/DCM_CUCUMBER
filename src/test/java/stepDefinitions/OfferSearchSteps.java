package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.OfferCreatePO;
import pages.PageFactoryManager;

public class OfferSearchSteps {
	WebDriver driver;
	private CommonPagePO commonPage;

	public OfferSearchSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
	}

	

}
