package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.OfferCreatePO;
import pages.PageFactoryManager;

public class CreateLocationGroupSteps {
	WebDriver driver;
	private CommonPagePO commonPage;

	public CreateLocationGroupSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
	}

	/*@When("^I select \"(.*?)\" with data \"(.*?)\"$")
	public void iSelectAssignedToUserIdWithData(String value, String text) {
		commonPage.selectValueFromDropdownList(value, text);
	}*/

	/*@When("^I select a value from smart search list with data \"(.*?)\"$")
	public void iSelectValueFromAssignedToList(String value) {
		commonPage.selectDynamicValueFromSmartSearchListWithOneDynamicValue(value);

	}*/

	
}
