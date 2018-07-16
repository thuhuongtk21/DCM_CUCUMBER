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
	private CommonPagePO commonPage;
	private AbstractTest abstractTest;
	//private LoginPagePO loginPage;
	private OfferMaintainPO offerMaintainPage;
	String username, password;

	public OfferMaintainPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		offerMaintainPage = PageFactoryManager.getOfferMaintainPage(driver);
		abstractTest = PageFactoryManager.getAbstractTestPage(driver);

	}
	
	/*@Then("^I verify expected data at \"(.*?)\" textbox with actual data \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		String actualValue1 = ShareData.value;
		abstractTest.verifyEquals(actualValue1, expectedValue);
	}*/
	
	@Then("^I verify expected data at \"(.*?)\" textbox with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextboxWithActualDataFromDatabase(String textboxName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value");		
		String actualValue = commonPage.getInforFromOfferTable(columnValue, schema, tableName, columnName, value);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@Then("^I verify expected data at \"(.*?)\" textarea with actual data of \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextareaWithActualDataFromDatabase(String textareName, String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		String expectedValue = commonPage.getDynamicValueInDynamicTextarea(textareName, "value");		
		String actualValue = commonPage.getInforFromOfferTable(columnValue, schema, tableName, columnName, value);
		System.out.println("Expected value = "+expectedValue);
		System.out.println("Actual value = "+actualValue);
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@When("^I click on Search icon$")
	public void iClickOnSearchIcon() {
		offerMaintainPage.clickOnSearchIcon();
	}

	

}
