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
	//String username, password;

	public CommonPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		loginPage = PageFactoryManager.getLoginPage(driver);
		abstractTest = PageFactoryManager.getAbstractTestPage(driver);

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

	@When("^I select a value from smart search list with \"(.*?)\" and \"(.*?)\"$")
	public void iSelectADynamicValueFromSmartSearchList(String value1, String value2) {
		commonPage.selectDynamicValueFromSmartSearchListWithTwoDynamicValue(value1, value2);

	}

	@When("^I select \"(.*?)\" with data \"(.*?)\"$")
	public void iSelectOneValueFromDynamicDropdownListWithDynamicData(String value, String selectedText) {
		commonPage.selectOneValueFromDynamicDropdownListWithDynamicData(value, selectedText);
	}

	@When("^I get data of column \"(.*?)\"$")
	public void iGetDataOfDynamicColumn(String value) {
		commonPage.getListItemOfOneColumnOnOnePage(value);
	}

	@Given("^I get data of column \"(.*?)\" on all pages$")
	public void iGetDataOfDynamicColumnOnAllPages(String value) {
		commonPage.getListItemOfOneColumnOnAllPages(value);

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

	@When("^I click on \"(.*?)\" text-box$")
	public void iClickOnDynamicTextbox(String value) {
		commonPage.clickOnDynamicTextbox(value);
	}

	@When("^I click on drop-down list$")
	public void iClickOnDropdownList() {
		commonPage.clickOnDropdownList();
	}

	@Given("^I click on \"(.*?)\" drop-down text-box$")
	public void iClickOnDynamicDropDownTextBox(String value) {
		commonPage.clickOnDropdownTextbox(value);

	}

	@When("^I press Enter key on \"(.*?)\" text-box$")
	public void iPressEnterKeyOnDynamicTextbox(String value) {
		commonPage.pressKeyOnDynamicTextbox(value);
	}

	@When("^I press TAB key on \"(.*?)\" text-box$")
	public void iPressTabKeyOnDynamicTextbox(String value) {
		commonPage.pressTabKeyOnDynamicTextbox(value);
	}

	@When("^I verify expected data at \"(.*?)\" textbox with actual data$")
	public void iVerifyExpectedDataWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		abstractTest.verifyEquals(actualValue, expectedValue);	}

	
	
	@Then("^I verify expected data at \"(.*?)\" textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataFromDatabase(String textboxName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");		
		String actualValue = commonPage.getInforFromDynamicTable(columnValue, schema, tableName, columnName, value);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" textarea with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextareaWithActualDataFromDatabase(String textareName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextarea(textareName, "value");		
		String actualValue = commonPage.getInforFromDynamicTable(columnValue, schema, tableName, columnName, value);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String labelName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);	
		String actualValue = commonPage.getInforFromDynamicTable(columnValue, schema, tableName, columnName, value);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" date time textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtDateTimeTextboxWithActualDatafFromDatabase(String textboxName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception  {	  
		String date = commonPage.getDynamicDateValueTextbox(textboxName, "value");
		String expectedValue = abstractTest.formatDateToYyyyMmDd(date);
		String actualValue = commonPage.getInforFromDynamicTable(columnValue, schema, tableName, columnName, value);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	/*@Then("^I verify expected data at \"(.*?)\" textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataOfFrom(String textboxName, String columValue, String database) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");		
		String actualValue = commonPage.getInforFromDatabase(columValue, from, where);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}*/
	
	@Then("^I verify expected data at \"(.*?)\" textbox with actual data \"(.*?)\" from \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataOfFrom(String textboxName, String columValue, String database) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");		
		String actualValue = commonPage.getInforFromDatabase(columValue, database);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String labelName, String columValue, String database) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);		
		String actualValue = commonPage.getInforFromDatabase(columValue, database);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		//abstractTest.verifyEquals(actualValue, expectedValue);		
		abstractTest.verifyTrue(actualValue.contains(expectedValue));
	}
	
	/*@Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" \"(.*?)\" from \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String labelName, List<String> listColumValue, String from, String where) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);		
		String actualValue = commonPage.getInforFromDatabase(listColumValue, from, where);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		//abstractTest.verifyEquals(actualValue, expectedValue);		
		//abstractTest.verifyTrue(actualValue.contains(expectedValue));
	}
*/
	@When("^I get all data on all pages in \"(.*?)\"$")
	public void iGetAllDataOnAllPages(String value) {
		commonPage.getListItemOfOneColumnOnOnePage(value);
	}

	@When("^I get all data on one pages in \"(.*?)\"$")
	public void iGetAllDataOnOnePages(String value) {
		commonPage.getListItemOfAllColumnsOnAllPages(value);
	}

	/*-------------Right click option-----------*/
	@Given("^I right click on a record which contains \"(.*?)\" value$")
	public void iRightClickOnARecordWhichContainsValue(String value) {
		commonPage.rightClickOnARecord(value);
	}

	@Given("^I select \"(.*?)\" option$")
	public void iSelectAnOptionFromContextMenu(String value) {
		commonPage.clickOnADynamicContextMenu(value);
	}

	@Then("^I verify \"(.*?)\" screen is open correctly$")
	public void iVerifySelectedScreenIsOpenedCorrectly(String value) {
		abstractTest.verifyTrue(commonPage.isSelectedScreenOpenCorrectly(value));
	}

	@When("^I verify \"(.*?)\" is shown correctly with selected Item \"(.*?)\"$")
	public void iVerifySelectedItemShownCorrectly(String textboxName, String value) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		abstractTest.verifyEquals(value, expectedValue);
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
		case "/DCM_UI/offer-acceptant|Accept/Reject":
			commonPage.openOfferAcceptPage(driver);
			break;
		case "/DCM_UI/browse-deals-and-costs1|Browse Deals and Costs":
			commonPage.openBrowseDealAndCostPage(driver);
			break;
		case "/DCM_UI/create-location-group|Create":
			commonPage.openCreateLocationGroupPage(driver);
			break;
		case "/DCM_UI/cost-maintenance|Maintain":
			commonPage.openCostMaintainPage(driver);
			break;
		case "/DCM_UI/deal-maintenance|Maintain":
			commonPage.openDealMaintainPage(driver);
			break;

		}
	}

}
