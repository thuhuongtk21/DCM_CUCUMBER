package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import interfaces.CommonPageUI;
import interfaces.SQL;

public class CommonPagePO extends AbstractPage {
	WebDriver driver;
	private AbstractTest abstractTest;

	public CommonPagePO(WebDriver driver_) {
		this.driver = driver_;
		abstractTest = PageFactoryManager.getAbstractTestPage(driver);
	}

	/*----------------------------TEXT-BOX----------------------------*/
	public void inputDynamicValueToDynamicTextBox(String textboxName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		sendKeyToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, value);
		// waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

	public String getDynamicValueInDynamicTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
	}

	public void clickOnDynamicTextbox(String value) {
		// waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
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

	/*----------------------------DATE TIME----------------------------*/

	public String getDynamicDateValueTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
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
		// waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
	}

	public void clickOnDropdownList() {
		// waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK);
	}

	public void clickOnDropdownTextbox(String value) {
		// waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_CLICK, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_ICON_TEXTBOX, value);
	}

	public void selectOneValueFromDynamicDropdownListWithDynamicData(String value, String selectedText) {
		// waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE, value, selectedText);
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
	}

	public void selectDynamicValueFromDropdownList(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX, value);
		hoverMouse(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE_TEXTBOX, value);

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

	/*----------------------------HYPERLINK----------------------------*/
	public void clickOnHyperlink(String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXT_LABEL, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_TEXT_LABEL, value);
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

	/*----------------------------TOOLTIP----------------------------*/
	public boolean isTooltipShow(String toolTipMessage, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_ICON, value);
		hoverMouse(driver, CommonPageUI.DYNAMIC_ICON, value);
		return isControlDisplayed(driver, CommonPageUI.DYNAMIC_TOOLTIP, toolTipMessage);
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
			System.out.println("List of item = " + addToFinalList);

		} while (isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE));
	}

	public void getListItemOfOneColumnOnOnePage(String value) {

		List<String> addToFinalList = new ArrayList<String>();
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		int countColumn = getSizeElement(driver, CommonPageUI.DYNAMIC_NUMBER_OF_COLUMN, value);
		for (int columnNumber = 0; columnNumber < countColumn; columnNumber++) {
			String columnNumber_Convert = Integer.toString(columnNumber);
			getListItemOnOnePage(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, columnNumber_Convert, addToFinalList);
			// System.out.println("List of Item on column "+columnNumber+ " and page
			// "+page+"="+addToFinalList);
		}
		System.out.println("Final list of column " + value + " = " + addToFinalList);

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
			for (int columnNumber = 0; columnNumber < countColumn; columnNumber++) {
				String columnNumber_Convert = Integer.toString(columnNumber);
				getListItemOnOnePage(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, columnNumber_Convert,
						addToFinalList);
				// System.out.println("List of Item on column "+columnNumber+ " and page
				// "+page+"="+addToFinalList);
			}

			System.out.println("List of item = " + addToFinalList);

		} while (isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE));
	}
	
	
	public void getListLableValueBasedOnDropdownSelected(String labelName, String columnValue, String schema, String tableName, String columnName, String value, List<String> getFromUi_List) throws Exception {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_LABEL_INPUT, labelName);
		List<String> outPut_List = new ArrayList<String>();
		List<String> UI_List = new ArrayList<String>();
		db_GetInforFromOneDynamicTable_oneColumn_listOutPut(columnValue, schema, tableName, columnName, value, outPut_List);
		for(String outPut_eachValue:outPut_List) {
			clickToElement(driver, CommonPageUI.DROP_DOWN_LIST);
			clickToElement(driver, CommonPageUI.DYNAMIC_DROP_DOWN_VALUE,outPut_eachValue);
			waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
			String getTextLableOnUI = getTextElement(driver, CommonPageUI.DYNAMIC_LABEL_INPUT, labelName);
			UI_List.add(getTextLableOnUI);
		}
		getFromUi_List.addAll(UI_List);
		System.out.println("All Item Type = "+getFromUi_List);
		
	}

	/*----------------------------PressKey----------------------------*/
	public void pressEnterKeyOnDynamicTextbox(String value) {
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
	public String db_GetInforFromOneDynamicTable_oneColumn(String columnValue, String schema, String tableName,
			String columnName, String value) throws Exception, Exception {
		String columnValue_Output = null;
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			columnValue_Output = rs.getString(columnValue).trim();
			System.out.println(columnValue + " from Database = " + columnValue_Output);
			switch (columnValue_Output) {
			case "0":
				columnValue_Output = columnValue_Output.replace("0", "");
				break;
			case "TPR":
				columnValue_Output = columnValue_Output.replace("TPR", "Trade Allowance");
				break;

			}
			switch(columnName) {
			case "DEAL_ENTY_ID":
				String sub_DealEntyId = columnValue_Output.substring(6);
				String removeZero_DealEntyId = sub_DealEntyId.replaceFirst("^0+(?!$)", "");
				columnValue_Output = removeZero_DealEntyId;
				break;
			}
		}
		st.close();
		System.out.println("Out put = "+ columnValue_Output);
		return columnValue_Output;
		

	}
	
	public List<String> db_GetInforFromOneDynamicTable_oneColumn_listOutPut(String columnValue, String schema, String tableName,
			String columnName, String value, List<String> outPut_List ) throws Exception, Exception {
		String columnValue_Output = null;
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			columnValue_Output = rs.getString(columnValue).trim();
			System.out.println(columnValue + " from Database = " + columnValue_Output);
			switch (columnValue_Output) {
			case "0":
				columnValue_Output = columnValue_Output.replace("0", "");
				break;
			case "TPR":
				columnValue_Output = columnValue_Output.replace("TPR", "Trade Allowance");
				break;

			}
			switch(columnValue) {
			case "DEAL_ENTY_ID":
				String sub_DealEntyId = columnValue_Output.substring(6);
				System.out.println("sub_DealEntyId = "+ sub_DealEntyId);
				String removeZero_DealEntyId = sub_DealEntyId.replaceFirst("^0+(?!$)", "");
				columnValue_Output = removeZero_DealEntyId;				
				break;
			
			}
			outPut_List.add(columnValue_Output);
		}		
		
		st.close();
		System.out.println("Out put = "+ outPut_List);
		
		
		return outPut_List;
		

	}
	
	public List<String> db_GetInforFromOneDynamicTable_oneColumn_listOutPut_2Tables(String columnValue, String schema, String tableName,
			String columnName, String value, String columnValue1, String tableName1, String columnName1, List<String> outPut_List, List<String> secondValue_list ) throws Exception, Exception {
		String columnValue_Output = null;
		String columnValue_Output_1 = null;
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			columnValue_Output = rs.getString(columnValue).trim();
			System.out.println(columnValue + " from Database = " + columnValue_Output);
			switch (columnValue_Output) {
			case "0":
				columnValue_Output = columnValue_Output.replace("0", "");
				break;
			case "TPR":
				columnValue_Output = columnValue_Output.replace("TPR", "Trade Allowance");
				break;

			}
			switch(columnValue) {
			case "DEAL_ENTY_ID":
				String sub_DealEntyId = columnValue_Output.substring(6);
				System.out.println("sub_DealEntyId = "+ sub_DealEntyId);
				String removeZero_DealEntyId = sub_DealEntyId.replaceFirst("^0+(?!$)", "");
				columnValue_Output = removeZero_DealEntyId;				
				break;
			
			}
			outPut_List.add(columnValue_Output);
		}
		System.out.println("outPut_List = "+ outPut_List);
				
		List<String> second_SQL_list = new ArrayList<String>();
		for(String outPut_EachValue:outPut_List) {
			String query1 = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName1, columnName1, outPut_EachValue);
			ResultSet rs1 = st.executeQuery(query1);
			while (rs1.next()) {
				columnValue_Output_1 = rs1.getString(columnValue1).trim();
				second_SQL_list.add(columnValue_Output_1);
			}
			secondValue_list.addAll(second_SQL_list);
		}
		
		st.close();
		System.out.println("Out put = "+ outPut_List);
		
		
		return secondValue_list;
		

	}

	public List<String> db_GetInforFromOneDynamicTable_listColumn(String listColumnValue, String schema,
			String tableName, String columnName, String value) throws Exception, Exception {
		String columnValue_Output = null;
		String[] myArray = listColumnValue.split(", ");
		List<String> myList = new ArrayList<>();
		for (String str : myArray) {
			myList.add(str);
		}
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		List<String> textList = new ArrayList<>();
		//List<String> textList_spe = new ArrayList<>();
		while (rs.next()) {
			for (String columnValue : myList) {
				{
					columnValue_Output = rs.getString(columnValue).trim();
					System.out.println(columnValue + " from Database = " + columnValue_Output);
					{
						switch (columnValue_Output) {
						case "AP":
							columnValue_Output = columnValue_Output.replace("AP", "WHS");
							break;
						case "DS":
							columnValue_Output = columnValue_Output.replace("DS", "DSD");

							break;
						}
						switch (columnValue) {

						case "RMIT_ST":
						case "RMIT_ZIP5_CD":
						case "RMIT_ZIP4_CD":
							/*textList_spe.add(columnValue_Output);
							System.out.println("switch case = " + textList_spe);*/
							break;
						case "OFR_CRE8D_TS":
						case "DELGTED_TS":
						case "LST_UPDT_TS":
							columnValue_Output = abstractTest.formatDateTime(columnValue_Output, "yyyy-MM-dd HH:mm:ss");
							break;
						case "OFR_CRE8_UID":
						case "DELGTED_BY_UID":
						case "LST_UPDT_UID":
							columnValue_Output = columnValue_Output.replace("p165114", "p165114 Peters,Carrol");
							break;
						
						}
					}
				}
				textList.add(columnValue_Output);
			}

		}
		st.close();
		// String finalText = String.join(" - ", textList);
		System.out.println("Final text = " + textList);
		String final_Text = String.join(" ", textList);
		System.out.println("Final text = " + final_Text);
		return textList;

	}

	public List<String> db_GetInforFromOneDynamicTable_listColumn_formatTime(String dateType, String listColumnValue,
			String schema, String tableName, String columnName, String value) throws Exception, Exception {
		String columnValue_Output = null;
		String[] myArray = listColumnValue.split(", ");
		List<String> myList = new ArrayList<>();
		for (String str : myArray) {
			myList.add(str);
		}
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQL(SQL.SQL_QUERY_FROM_ONE_TABLE, schema, tableName, columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		List<String> textList = new ArrayList<>();
		List<String> textList_spe = new ArrayList<>();
		while (rs.next()) {
			for (String columnValue : myList) {
				{
					columnValue_Output = rs.getString(columnValue).trim();
					System.out.println(columnValue + " from Database = " + columnValue_Output);
					{
						switch (columnValue_Output) {
						case "AP":
							columnValue_Output = columnValue_Output.replace("AP", "WHS");
							break;
						case "DS":
							columnValue_Output = columnValue_Output.replace("DS", "DSD");

							break;
						}
						switch (columnValue) {

						case "RMIT_ST":
						case "RMIT_ZIP5_CD":
						case "RMIT_ZIP4_CD":
							textList_spe.add(columnValue_Output);
							System.out.println("swicth case = " + textList_spe);
							break;
						case "OFR_CRE8D_TS":
						case "DELGTED_TS":
						case "LST_UPDT_TS":
							columnValue_Output = abstractTest.formatDateTime(columnValue_Output, dateType);
							break;
						case "OFR_CRE8_UID":
						case "DELGTED_BY_UID":
						case "LST_UPDT_UID":
							columnValue_Output = columnValue_Output.replace("p165114", "p165114 Peters,Carrol");
						}
					}
				}
				textList.add(columnValue_Output);
			}

		}
		st.close();
		// String finalText = String.join(" - ", textList);
		System.out.println("Final text = " + textList);
		String final_Text = String.join(" ", textList);
		System.out.println("Final text = " + final_Text);
		return textList;

	}

	public List<String> db_GetInforFromTwoDynamicTable(String listColumnValue, String schema, String tableName,
			String tableName1, String onCondition, String columnName, String value) throws Exception, Exception {
		String columnValue_Output = null;
		String[] myArray = listColumnValue.split(", ");
		List<String> myList = new ArrayList<>();
		for (String str : myArray) {
			myList.add(str);
		}
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQLFromTwoTable(SQL.DYNAMIC_SQL_TWO_TABLES, schema, tableName, tableName1, onCondition,
				columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		List<String> textList = new ArrayList<>();
		List<String> textList_spe = new ArrayList<>();
		while (rs.next()) {
			for (String columnValue : myList) {
				{
					columnValue_Output = rs.getString(columnValue).trim();
					System.out.println(columnValue + " from Database = " + columnValue_Output);
					{
						switch (columnValue_Output) {
						case "AP":
							columnValue_Output = columnValue_Output.replace("AP", "WHS");
							break;
						case "DS":
							columnValue_Output = columnValue_Output.replace("DS", "DSD");

							break;
						}
						switch (columnValue) {

						case "RMIT_ST":
						case "RMIT_ZIP5_CD":
						case "RMIT_ZIP4_CD":
							textList_spe.add(columnValue_Output);
							System.out.println("swicth case = " + textList_spe);
							break;
						case "OFR_CRE8D_TS":
						case "DELGTED_TS":
						case "LST_UPDT_TS":
							columnValue_Output = abstractTest.formatDateTime(columnValue_Output, "yyyy-MM-dd HH:mm:ss");
							break;
						case "OFR_CRE8_UID":
						case "DELGTED_BY_UID":
						case "LST_UPDT_UID":
							columnValue_Output = columnValue_Output.replace("p165114", "p165114 Peters,Carrol");
						}
					}
				}
				textList.add(columnValue_Output);
			}

		}
		st.close();
		// String finalText = String.join(" - ", textList);
		System.out.println("Final text = " + textList);
		String final_Text = String.join(" ", textList);
		System.out.println("Final text = " + final_Text);
		return textList;

	}

	public List<String> db_GetInforFromTwoDynamicTableWithDatetimeFormat(String dateType, String listColumnValue,
			String schema, String tableName, String tableName1, String onCondition, String columnName, String value)
			throws Exception, Exception {
		String columnValue_Output = null;
		String[] myArray = listColumnValue.split(", ");
		List<String> myList = new ArrayList<>();
		for (String str : myArray) {
			myList.add(str);
		}
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQLFromTwoTable(SQL.DYNAMIC_SQL_TWO_TABLES, schema, tableName, tableName1, onCondition,
				columnName, value);
		System.out.println("Query = " + query);
		ResultSet rs = st.executeQuery(query);
		List<String> textList = new ArrayList<>();
		List<String> textList_spe = new ArrayList<>();
		while (rs.next()) {
			for (String columnValue : myList) {
				{
					columnValue_Output = rs.getString(columnValue).trim();
					System.out.println(columnValue + " from Database = " + columnValue_Output);
					{
						switch (columnValue_Output) {
						case "AP":
							columnValue_Output = columnValue_Output.replace("AP", "WHS");
							break;
						case "DS":
							columnValue_Output = columnValue_Output.replace("DS", "DSD");
						case "p165114":
							columnValue_Output = columnValue_Output.replace("p165114", "p165114 Peters,Carrol");
							break;
						case "cert1":
							columnValue_Output = columnValue_Output.replace("cert1", "cert1 Robert Alston");
							break;
						}
						switch (columnValue) {

						case "RMIT_ST":
						case "RMIT_ZIP5_CD":
						case "RMIT_ZIP4_CD":
							textList_spe.add(columnValue_Output);
							System.out.println("swicth case = " + textList_spe);
							break;
						case "OFR_CRE8D_TS":
						case "DELGTED_TS":
						case "LST_UPDT_TS":
							columnValue_Output = abstractTest.formatDateTime(columnValue_Output, dateType);
							break;
						/*
						 * case "OFR_CRE8_UID": case "DELGTED_BY_UID": case "LST_UPDT_UID":
						 * columnValue_Output = columnValue_Output.replace("p165114",
						 * "p165114 Peters,Carrol");
						 */
						}
					}
				}
				textList.add(columnValue_Output);
			}

		}
		st.close();
		// String finalText = String.join(" - ", textList);
		System.out.println("Final text = " + textList);
		String final_Text = String.join(" ", textList);
		System.out.println("Final text = " + final_Text);
		return textList;

	}

	/*
	 * public String getInforFromDatabase(List<String> listColumValue, String
	 * database) throws Exception, Exception { String columnValue_Output = null;
	 * Connection connection = connectToDatabase(); Statement st =
	 * connection.createStatement(); String query =
	 * formatSQLFromAndWhere(SQL.DYNAMIC_SQL_QUERY, database);
	 * System.out.println("Query = " + query); ResultSet rs =
	 * st.executeQuery(query); for(String columnValue:listColumValue) {
	 * columnValue_Output = rs.getString(columnValue).trim();
	 * System.out.println(columnValue + " from Database = " + columnValue_Output); }
	 * 
	 * st.close(); return columnValue_Output;
	 * 
	 * }
	 */

	public String getInforFromDatabase(String columValue, String database) throws Exception, Exception {
		String columnValue_Output = null;
		Connection connection = connectToDatabase();
		Statement st = connection.createStatement();
		String query = formatSQLFromAndWhere(SQL.DYNAMIC_SQL_QUERY, database);
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

	public LGMaintainPO openLocationGroupMaintainPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Location Group");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/location-group-maintain", "Maintain");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getLocationGroupMaintainPage(driver);
	}

	public CostMaintainPagePO openCostMaintainPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Cost");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/cost-maintenance", "Maintain");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getCostMaintainPage(driver);
	}

	public DealsMaintainPO openDealMaintainPage(WebDriver driver) {
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "#", "Deals");
		clickToElement(driver, CommonPageUI.MENU_DYNAMIC_LINK, "/DCM_UI/deal-maintenance", "Maintain");
		waitForControlInvisible(driver, CommonPageUI.LOADING_BAR);
		return PageFactoryManager.getDealsMaintainPage(driver);
	}

}
