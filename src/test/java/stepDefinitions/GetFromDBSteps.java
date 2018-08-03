package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.OfferCreatePO;
import pages.PageFactoryManager;

public class GetFromDBSteps {
	WebDriver driver;
	private CommonPagePO commonPage;

	public GetFromDBSteps() {
		
		commonPage = PageFactoryManager.getCommonPage(driver);
	}

	
	@Given("^I get \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iGetFrom(String columnValue, String schema, String tableName, String columnName, String value) throws Throwable {
		List<String> outPut_List = new ArrayList<String>();
	    commonPage.db_GetInforFromOneDynamicTable_oneColumn_listOutPut(columnValue, schema, tableName, columnName, value, outPut_List);
	    System.out.println("Final list = "+outPut_List);
	}
	
	@Given("^item \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" and verify with \"(.*?)\" from \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void iGetItemFromAndVerifyWithFrom(String columnValue, String schema, String tableName, String columnName, String value, String columnValue1, String schema1, String tableName1, String columnName1) throws Throwable {
	    List<String> outPut_List = new ArrayList<String>();
	    List<String> secondValue_list = new ArrayList<String>();
		commonPage.db_GetInforFromOneDynamicTable_oneColumn_listOutPut_2Tables(columnValue, schema, tableName, columnName, value, columnValue1, schema1, tableName1, columnName1, outPut_List, secondValue_list);
		System.out.println("outPut_List = "+ outPut_List);
		System.out.println("secondValue_list = "+ secondValue_list);
	}
	

}
