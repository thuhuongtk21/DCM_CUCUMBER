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
import pages.PageFactoryManager;

public class CommonPageSteps extends AbstractPage {
	WebDriver driver;
	private CommonPagePO commonPage;
	private AbstractTest abstractTest;
	private LoginPagePO loginPage;
	String username, password;

	public CommonPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		loginPage = PageFactoryManager.getLoginPage(driver);

	}

	@Given("^I login to application$")
	public void iLoginToApplication() {
		loginPage.loginToApplication();

	}

	@When("^I input to \"(.*?)\" text-box with data \"(.*?)\"$")
	public void iInputDataInWithData(String textboxName, String value) {
		commonPage.inputDynamicValueToDynamicTextBox(textboxName, value);
	}
	
	@When("^I input to \"(.*?)\" text-area with data \"(.*?)\"$")
	public void iInputDataToTextareaWithData(String textareaName, String value) {
		commonPage.inputDynamicValueToDynamicTextarea(textareaName, value);
	}

	@When("^I select a Vendor from smart search list with data \"(.*?)\" and \"(.*?)\"$")
	public void iSelectADynamicValueFromSmartSearchList(String value1, String value2) {
		commonPage.selectDynamicValueFromSmartSearchListWithTwoDynamicValue(value1, value2);

	}
	
	@When("^I get data of column \"(.*?)\"$")
	public void iGetDataOfDynamicColumn(String value) {
		commonPage.getListItemOfOneColumn(value);
	}

	@When("^I click on \"(.*?)\" icon$")
	public void iClickOnDynamicIcon(String value) {
		commonPage.clickOnDymamicIcon(value);
	}
	
	@When("^I click on \"(.*?)\" button$")
	public void iClickOnDynamicButton(String value) {
		commonPage.clickOnDynamicButton(value);
	}
	
	@When("^I click on \"(.*?)\" drop-down list$")
	public void iClickOnDynamicDropdownList(String value) {
	    commonPage.clickOnDropdownIcon(value);
	}
	
	@When("^I press key on \"(.*?)\" textbox$")
	public void iPressEnterKeyOnDynamicTextbox(String value) {
	    commonPage.pressKeyOnDynamicTextbox(value);
	}
	
	@When("^I verify expected data at \"(.*?)\" textbox with actual data$")
	public void iVerifyExpectedDataWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" textbox with actual data in \"(.*?)\" \"(.*?)\" table \"(.*?)\" column and \"(.*?)\" value$")
	public void iVerifyExpectedDataAtTextboxWithActualDataInDB(String textboxName, String schema, String tableName, String columnName, String value) {
		//String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		//String actualValue = offerTable.getDataFromDatabase(schema, tableName, columnName, value);
		//abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	

	@Given("^I open \"(.*?)\" \"(.*?)\" screen$")
	public void iOpenDynamicScreen(String menu, String subMenu) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   switch (menu + "|" + subMenu) {
	   case "/DCM_UI/offer-create|Create":
		   commonPage.openOfferCreatePage(driver);
		   break;
	   case "/DCM_UI/offer-search|Search":
		   commonPage.openOfferSearchPage(driver);
		   break;
	   case "/DCM_UI/offer-maintain|Maintain":
		   commonPage.openOfferMaintainPage(driver);
		   break;
	   case "/DCM_UI/deal-builder|Deal Builder":
		   commonPage.openDealBuilderPage(driver);
		   break;
	   case "/DCM_UI/offer-review|Review":
		   commonPage.openOfferReviewPage(driver);
		   break;
	   case "/DCM_UI/browse-deals-and-costs1|Browse Deals and Costs":
	   		commonPage.openBrowseDealAndCostPage(driver);
	   break;
	   case "/DCM_UI/create-location-group|Create":
	   		commonPage.openCreateLocationGroupPage(driver);
	   break;
	   
	   }
	}

}
