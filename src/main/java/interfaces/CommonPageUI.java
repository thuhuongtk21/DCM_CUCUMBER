package interfaces;

public class CommonPageUI {
	public static final String MENU_DYNAMIC_LINK = "//a[@href='%s' and text()='%s']";
	public static final String LEAVE_CONFIRM = "//button[text()='Leave Page']";
	public static final String LOADING_BAR = "//span[@class='loading-text' and contains(text(),' Please wait...')]";
	public static final String DYNAMIC_INPUT_TEXTBOX = "//*[@id=\"%s\"]";
	public static final String DYNAMIC_INPUT_TEXTAREA = "//textarea[@id='%s']";
	public static final String SMART_SEARCH_VENDOR_LIST = "//*[contains(@id,'ui-id')]/a";
	public static final String SMART_SEARCH_TEXTBOX_LIST = "//ul[contains(@id,'ui-id-2')]/li/a";
	public static final String DYNAMIC_ICON = "//span[@id='%s']";
	public static final String DYNAMIC_DROP_DOWN_CLICK = "//button[@data-id='%s']﻿";
	public static final String DYNAMIC_DROP_DOWN_VALUE = "//span[contains(text(),'%s')]";
	public static final String DYNAMIC_PAGE = "//a[@page='%s']";
	public static final String GET_DATA_DYNAMIC_COLUMN = "//tr[@class='odd' or @class='even']/td[%s]";
	public static final String ENABLE_NEXT_PAGE = "//a[@class='paginate_button next' and text()='Next']";
	public static final String DYNAMIC_BUTTON = "//button[@id='%s']";

}
