package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

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
	// String username, password;

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

	@When("^I click to \"(.*?)\"$")
	public void iClickToHereLink(String value) {
		commonPage.clickToHereLink();
	}

	@When("^I scroll to bottom$")
	public void iScrollToButtom() {
		commonPage.scrollToBottom();

	}

	@When("^I scroll to top$")
	public void iScrollToTop() {
		commonPage.scrollToTop();

	}

	@Given("^I click on \"(.*?)\" drop-down icon$")
	public void iClickOnDropDownIcon(String value) {
		commonPage.clickOnDropdownIcon_SmartSearch(value);
	}

	@Then("^I get all vendors list$")
	public void iGetAllVendorsList() throws Throwable {
		commonPage.getAllValuesInDropdownList();
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

	@Given("^I click on \"(.*?)\"$")
	public void iClickOnADynamicTextValue(String value) {
		commonPage.clickOnADynamicTextValue(value);
	}

	@When("^I click on \"(.*?)\" button$")
	public void iClickOnDynamicButton(String value) {
		commonPage.clickOnDynamicButton(value);
	}

	@When("^I click on \"(.*?)\" hyperlink$")
	public void iClickOnHyperlink(String value) {
		commonPage.clickOnHyperlink(value);
	}

	@When("^I click on \"(.*?)\" drop-down list$")
	public void iClickOnDynamicDropdownList(String value) {
		commonPage.clickOnDropdownIcon_Button(value);
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

	@When("^I press ENTER key on \"(.*?)\" text-box$")
	public void iPressEnterKeyOnDynamicTextbox(String value) {
		commonPage.pressEnterKeyOnDynamicTextbox(value);
	}

	@When("^I press TAB key on \"(.*?)\" text-box$")
	public void iPressTabKeyOnDynamicTextbox(String value) {
		commonPage.pressTabKeyOnDynamicTextbox(value);
	}

	@Given("^I verify all \"(.*?)\" on UI with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" and verify with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iGetItemFromAndVerifyWithFrom(String labelName, String columnValue, String schema, String tableName,
			String columnName, String value, String columnValue1, String schema1, String tableName1, String columnName1)
			throws Throwable {
		List<String> outPut_List = new ArrayList<String>();
		List<String> secondValue_list = new ArrayList<String>();
		commonPage.db_GetInforFromOneDynamicTable_oneColumn_listOutPut_2Tables(columnValue, schema, tableName,
				columnName, value, columnValue1, schema1, tableName1, columnName1, outPut_List, secondValue_list);
		List<String> actualValue = secondValue_list;
		List<String> getFromUi_List = new ArrayList<String>();
		commonPage.getListLableValueBasedOnDropdownSelected(labelName, columnValue, schema, tableName, columnName,
				value, getFromUi_List);
		List<String> expectedValue = getFromUi_List;
		System.out.println("outPut_List = " + outPut_List);
		System.out.println("secondValue_list = " + secondValue_list);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	/* ==================VERIFY WITH DATABASE============== */

	/*--------------Textbox - Get from one Table------------*/

	@Then("^I verify \"(.*?)\" textbox shows correctly with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyDataAtTextboxIsShowingCorrectlyWithFrom(String textboxName, String columnValue, String schema,
			String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);

	}

	/*--------------Textbox - Get from two Tables------------*/
	@Then("^I verify \"(.*?)\" textbox shows correctly in format \"(.*?)\" with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyVendorTextboxIsShowingCorrectlyWithFrom(String textboxName, String format,
			String listColumnValue, String schema, String tableName, String tableName1, String onCondition,
			String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		// String actualValue = commonPage.getInforFromTwoDynamicTable(listColumnValue,
		// schema, tableName, tableName1, columnName, value);
		List<String> finalText = commonPage.db_GetInforFromTwoDynamicTable(listColumnValue, schema, tableName,
				tableName1, onCondition, columnName, value);
		String actualValue = String.join(format, finalText);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	/*--------------Textarea - Get from one Table------------*/
	@Then("^I verify \"(.*?)\" textarea is showing correctly with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyDataAtTextareIsShowingCorrectlyWithFrom(String textareName, String columnValue, String schema,
			String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicTextarea(textareName, "value");
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);

	}

	/*--------------Label - Get from one Table------------*/
	@Then("^I verify \"(.*?)\" label shows correctly with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyDataAtLabelIsShowingCorrectlyWithFrom(String labelName, String columnValue, String schema,
			String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);

	}

	@Then("^I verify \"(.*?)\" label and date time shows correctly in format \"(.*?)\" \"(.*?)\" with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyLabelAndDateTimeShowsCorrectlyInFormatWithFrom(String labelName, String format, String dateType,
			String listColumnValue, String schema, String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		List<String> finalText = commonPage.db_GetInforFromOneDynamicTable_listColumn_formatTime(dateType,
				listColumnValue, schema, tableName, columnName, value);
		String actualValue = String.join(format, finalText);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	/*--------------Label - Get from two Tables------------*/

	@Then("^I verify \"(.*?)\" label shows correctly in format \"(.*?)\" with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyLabelIsShowingCorrectlyWithFrom(String labelName, String format, String listColumnValue,
			String schema, String tableName, String tableName1, String onCondition, String columnName, String value)
			throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		// String actualValue = commonPage.getInforFromTwoDynamicTable(listColumnValue,
		// schema, tableName, tableName1, columnName, value);
		List<String> finalText = commonPage.db_GetInforFromTwoDynamicTable(listColumnValue, schema, tableName,
				tableName1, onCondition, columnName, value);
		String actualValue = String.join(format, finalText);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Given("^I verify \"(.*?)\" label and date time shows correctly in format \"(.*?)\" \"(.*?)\" with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyLabelAndDateTimeIsShowingCorrectlyInFormatWithFrom(String labelName, String format,
			String dateType, String listColumnValue, String schema, String tableName, String tableName1,
			String onCondition, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		List<String> finalText = commonPage.db_GetInforFromTwoDynamicTableWithDatetimeFormat(dateType, listColumnValue,
				schema, tableName, tableName1, onCondition, columnName, value);
		String actualValue = String.join(format, finalText);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify \"(.*?)\" date time label shows correctly with format \"(.*?)\" of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyDataAtDateTimeLabelIsShowingCorrectlyWithFormatOfFrom(String labelName, String dateType,
			String columnValue, String schema, String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		String date = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName, columnName,
				value);
		String actualValue = abstractTest.formatDateTime(date, dateType);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify \"(.*?)\" date time textbox shows correctly with format \"(.*?)\" of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyDataAtDateTimeTextboxIsShowingCorrectlyWithFormatOfFrom(String textboxName, String dateType,
			String columnValue, String schema, String tableName, String columnName, String value) throws Throwable {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		String date = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName, columnName,
				value);
		String actualValue = abstractTest.formatDateTime(date, dateType);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify \"(.*?)\" date time textbox shows correctly with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtDateTimeTextboxWithActualDatafFromDatabase(String textboxName, String columnValue,
			String schema, String tableName, String columnName, String value) throws Exception {
		String date = commonPage.getDynamicDateValueTextbox(textboxName, "value");
		String expectedValue = abstractTest.formatDateTime(date, "mm-dd-yyyy");
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	/*--------------Tooltip------------*/

	@Then("^I verify \"(.*?)\" is shown when hover on \"(.*?)\"$")
	public void iVerifyTooltipIsShownWhenHoverOnAnIcon(String toolTipMessage, String value) {
		abstractTest.verifyTrue(commonPage.isTooltipShow(toolTipMessage, value));
	}

	/*--------------------------*/

	@When("^I verify expected data at \"(.*?)\" textbox with actual data$")
	public void iVerifyExpectedDataWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify expected data at \"(.*?)\" textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataFromDatabase(String textboxName, String columnValue,
			String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify expected data at \"(.*?)\" textarea with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextareaWithActualDataFromDatabase(String textareName, String columnValue,
			String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextarea(textareName, "value");
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String labelName, String columnValue,
			String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		String actualValue = commonPage.db_GetInforFromOneDynamicTable_oneColumn(columnValue, schema, tableName,
				columnName, value);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	/*
	 * @Then("^I verify expected data at \"(.*?)\" textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\"$"
	 * ) public void iVerifyExpectedDataAtTextboxWithActualDataOfFrom(String
	 * textboxName, String columValue, String database) throws Exception { String
	 * expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName,
	 * "value"); String actualValue = commonPage.getInforFromDatabase(columValue,
	 * from, where); System.out.println("Expected value = "+expectedValue);
	 * System.out.println("Actual value = "+actualValue);
	 * abstractTest.verifyEquals(actualValue, expectedValue); }
	 */

	@Then("^I verify expected data at \"(.*?)\" textbox with actual data \"(.*?)\" from \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataOfFrom(String textboxName, String columValue, String database)
			throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");
		String actualValue = commonPage.getInforFromDatabase(columValue, database);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}

	@Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String labelName, String columValue,
			String database) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicLabel(labelName);
		String actualValue = commonPage.getInforFromDatabase(columValue, database);
		System.out.println("Expected value = " + expectedValue);
		System.out.println("Actual value = " + actualValue);
		// abstractTest.verifyEquals(actualValue, expectedValue);
		abstractTest.verifyTrue(actualValue.contains(expectedValue));
	}

	/*
	 * @Then("^I verify expected data at \"(.*?)\" label with actual data of \"(.*?)\" \"(.*?)\" from \"(.*?)\" \"(.*?)\"$"
	 * ) public void iVerifyExpectedDataAtLabelWithActualDataFromDatabase(String
	 * labelName, List<String> listColumValue, String from, String where) throws
	 * Exception { String expectedValue =
	 * commonPage.getDynamicValueInDynamicLabel(labelName); String actualValue =
	 * commonPage.getInforFromDatabase(listColumValue, from, where);
	 * System.out.println("Expected value = "+expectedValue);
	 * System.out.println("Actual value = "+actualValue);
	 * //abstractTest.verifyEquals(actualValue, expectedValue);
	 * //abstractTest.verifyTrue(actualValue.contains(expectedValue)); }
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
		case "/DCM_UI/location-group-maintain|Maintain":
			commonPage.openLocationGroupMaintainPage(driver);
			break;
		case "/DCM_UI/cost-maintenance|Maintain":
			commonPage.openCostMaintainPage(driver);
			break;
		case "/DCM_UI/deal-maintenance|Maintain":
			commonPage.openDealMaintainPage(driver);
			break;
		case "/DCM_UI/cost-link-maintenance|Cost Link Maintenance":
			commonPage.openCostLinkMaintainPage(driver);
			break;

		}

	}
}
