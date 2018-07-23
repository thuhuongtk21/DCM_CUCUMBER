package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.DealBuilderPagePO;
import pages.PageFactoryManager;

public class DealBuilderPageSteps {
	WebDriver driver;
	//private CommonPagePO commonPage;
	private DealBuilderPagePO dealBuilderPage;

	public DealBuilderPageSteps() {
		driver = Hooks.openBrowser();
		//commonPage = PageFactoryManager.getCommonPage(driver);
		dealBuilderPage = PageFactoryManager.getDealBuilderPage(driver);
	}

	@Given("^I click on \"(.*?)\" option$")
	public void iClickOnDealOption(String value) {
		dealBuilderPage.clickOnADealType(value);
	}

	@Given("^I click on \"(.*?)\" sub option$")
	public void iClickOnSubDealOption(String value) {
		dealBuilderPage.clickOnASubDealType(value);
	}

	@Given("^I click on \"(.*?)\" level$")
	public void iClickOnDealLevel(String value)  {
		dealBuilderPage.clickOnALevel(value);
	}

}
