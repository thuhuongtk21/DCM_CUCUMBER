package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.OfferMaintainPO;
import pages.PageFactoryManager;

public class getOwnerFromOfferTable {
	WebDriver driver;
	
	
	private CommonPagePO commonPage;
	public getOwnerFromOfferTable() {
		commonPage = PageFactoryManager.getCommonPage(driver);
	}
	
	@When("^I get \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iGetFrom(String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		//commonPage.getInforFromOfferTable(columnValue, schema, tableName, columnName, value);
	}

}
