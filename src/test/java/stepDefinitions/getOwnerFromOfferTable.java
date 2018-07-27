package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;
import pages.CommonPagePO;
import pages.PageFactoryManager;

public class getOwnerFromOfferTable {
	WebDriver driver;
	
	
	private CommonPagePO commonPage;
	public getOwnerFromOfferTable() {
		commonPage = PageFactoryManager.getCommonPage(driver);
	}
	
	/*@When("^I get \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iGetFrom(String columnValue, String schema, String tableName, String columnName, String value) throws Exception {
		commonPage.db_GetInforFromOneDynamicTable(columnValue, schema, tableName, columnName, value);
	}
	
	@When("^I try to get \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iTryToGetFrom(String listColumnValue, String schema, String tableName, String tableName1, String onCondition, String columnName, String value) throws Throwable {
		commonPage.db_GetInforFromTwoDynamicTable(listColumnValue, schema, tableName, tableName1, onCondition, columnName, value);
	    
	}*/

}
