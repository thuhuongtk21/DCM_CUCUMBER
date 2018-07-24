package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.CommonPageUI;
import interfaces.CostMaintainPageUI;
import interfaces.OfferSearchUI;
import interfaces.SQL;

public class CommonPagePO extends AbstractPage {
	WebDriver driver;

	public CommonPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	/*----------------------------TEXT-BOX----------------------------*/
	public void inputDynamicValueToDynamicTextBox(String textboxName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		sendKeyToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, value);
		//waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

	public String getDynamicValueInDynamicTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
	}
	
	public void clickOnDynamicTextbox(String value) {
		//waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, value);
	}

	/*----------------------------TEXT-AREA----------------------------*/
	public void inputDynamicValueToDynamicTextarea(String textareaName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textareaName);
		sendKeyToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textareaName, value);
	}

	public String getDynamicValueInDynamicTextarea(String textareName, String attributeName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTAREA, textareName);
		return getAttributeValue(driver, CommonPageUI.DYNAMIC_INPUT_TEXTAREA, textareName, attributeName);
	}
	
	/*----------------------------SMART SEARCH WITH ONE DYNAMIC VALUE----------------------------*/
	public void selectDynamicValueFromSmartSearchListWithOneDynamicValue(String value) {
		waitForControlVisible(driver, CommonPageUI.SMART_SEARCH_LIST);
		getListElementWithOneDynamicvalue(driver, CommonPageUI.SMART_SEARCH_LIST, value);
	}

	public void clickOnDymamicIcon(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_ICON, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_ICON, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}


	/*----------------------------SMART SEARCH WITH TWO DYNAMIC VALUE----------------------------*/
	public void selectDynamicValueFromSmartSearchListWithTwoDynamicValue(String value1, String value2) {
		waitForControlVisible(driver, CommonPageUI.SMART_SEARCH_LIST);
		getListElementWithTwoDynamicvalue(driver, CommonPageUI.SMART_SEARCH_LIST, value1, value2);
	}

	
	/*----------------------------DROP_DOWN----------------------------*/
	public void clickOnDropdownIcon(String value) {
		//waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
	}
	
	public void clickOnDropdownList() {
		//waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK);
	}
	
	public void clickOnDropdownTextbox(String value) {
		//waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_ICON_TEXTBOX, value);
	}

	public void selectOneValueFromDynamicDropdownListWithDynamicData(String value, String selectedText) {
		//waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE, value, selectedText);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}
	
	public void selectDynamicValueFromDropdownList(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX, value);
		hoverMouse(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX,value);
	
	}
	/*--------------------------------------------------------*/

	/*----------------------------LABEL----------------------------*/

	public String getDynamicValueInDynamicLabel(String labelName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_LABEL, labelName);
		return getTextElement(driver, CommonPageUI.DYNAMIC_LABEL, labelName);
	}

	/*----------------------------BUTTON----------------------------*/
	public void clickOnDynamicButton(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_BUTTON, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}
	
	/*----------------------------CONTEXT MENU----------------------------*/
	
	public void rightClickOnARecord(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_SELECTED_RECORD, value);
		rightClick(driver, CommonPageUI.DYNAMIC_SELECTED_RECORD, value);
	}
	
	public void clickOnADynamicContextMenu(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_CONTEXT_MENU, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_CONTEXT_MENU, value);
		waitForControlInvisible(driver, CommonPageUI.DYNAMIC_CONTEXT_MENU);
	}
	
	public boolean isSelectedScreenOpenCorrectly(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_SCREEN_NAME, value);
		return isControlDisplayed(driver, CommonPageUI.DYNAMIC_SCREEN_NAME, value);
	}

	/*----------------------------GET LIST DATA FROM SEARCH RESULT----------------------------*/

	public void getListItemOfOneColumnOnAllPages(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		List<String> addToFinalList = new ArrayList<String>();
		int page = 0;
		do {
			if (!isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE))
				break;
			page = page + 1;
			clickOnPageNumber(driver, CommonPageUI.DYNAMIC_PAGE, page);
			waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
			getListItemOnOnePage(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, value, addToFinalList);
			System.out.println("List of item = "+ addToFinalList);

		} while (isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE));
	}

	public void getListItemOfOneColumnOnOnePage(String value) {

		List<String> addToFinalList = new ArrayList<String>();
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		int countColumn = getSizeElement(driver, CommonPageUI.DYNAMIC_NUMBER_OF_COLUMN, value);
		for(int columnNumber = 0; columnNumber < countColumn; columnNumber++) {
			String columnNumber_Convert = Integer.toString(columnNumber);
			getListItemOnOnePage(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, columnNumber_Convert, addToFinalList);
			//System.out.println("List of Item on column "+columnNumber+ " and page "+page+"="+addToFinalList);
		}
		System.out.println("Final list of column "+value+" = "+addToFinalList);

	}
	
	public void getListItemOfAllColumnsOnAllPages(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		List<String> addToFinalList = new ArrayList<String>();
		int page = 0;
		do {
			if (!isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE))
				break;
			page = page + 1;
			clickOnPageNumber(driver, CommonPageUI.DYNAMIC_PAGE, page);
			waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
			int countColumn = getSizeElement(driver, CommonPageUI.DYNAMIC_NUMBER_OF_COLUMN, value);
			for(int columnNumber = 0; columnNumber < countColumn; columnNumber++) {
				String columnNumber_Convert = Integer.toString(columnNumber);
				getListItemOnOnePage(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, columnNumber_Convert, addToFinalList);
				//System.out.println("List of Item on column "+columnNumber+ " and page "+page+"="+addToFinalList);
			}
			
			System.out.println("List of item = "+ addToFinalList);

		} while (isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE));
	}

	/*----------------------------PressKey----------------------------*/
	public void pressKeyOnDynamicTextbox(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, value);
		dynamicEnterKeyPress(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}
	
	public void pressTabKeyOnDynamicTextbox(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, value);
		dynamicTabKeyPress(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, value);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

	/*----------------------------Get data from Database----------------------------*/
	public String getInforFromOfferTable(String columValue, String schema, String tableName, String columnName,
			String value) throws Exception, Exception {
		String columnValue_Output = null;
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			columnValue_Output = rs.getString(columValue).trim();
			System.out.println(columValue + " from Database = " + columnValue_Output);
		}
		st.close();
		return columnValue_Output;

	}

	/*----------------------------OPEN DYNAMIC PAGES----------------------------*/
	public OfferCreatePO openOfferCreatePage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/offer-create", "Create");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getOfferCreatePage(driver);
	}

	public DealBuilderPagePO openDealBuilderPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/deal-builder", "Deal Builder");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getDealBuilderPage(driver);
	}

	public OfferReviewPO openOfferReviewPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/offer-review", "Review");
		/*
		 * if(isControlDisplayed(driver, AbstractPageUI.LEAVE_CONFIRM) == true) {
		 * clickToElement(driver, AbstractPageUI.LEAVE_CONFIRM); }
		 */
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getOfferReviewPage(driver);
	}

	public OfferAccpetPO openOfferAcceptPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/offer-acceptant", "Accept/Reject");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getOfferAcceptPage(driver);
	}

	public OfferSearchPO openOfferSearchPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/offer-search", "Search");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getOfferSearchPage(driver);
	}

	public OfferMaintainPO openOfferMaintainPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Offer");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/offer-maintain", "Maintain");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getOfferMaintainPage(driver);
	}

	public BrowseDealAndCostPagePO openBrowseDealAndCostPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Cost");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/browse-deals-and-costs1",
				"Browse Deals and Costs");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getBrowseDealAndCostPage(driver);
	}

	public LGCreatePO openCreateLocationGroupPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Location Group");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/create-location-group", "Create");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getCreateLocationGroupPage(driver);
	}
	
	public CostMaintainPagePO openCostMaintainPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Cost");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/cost-maintenance", "Maintain");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getCostMaintainPage(driver);
	}

}
