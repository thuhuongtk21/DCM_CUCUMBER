package interfaces;

public class CommonPageUI {
	public static final String MENU_DYNAMIC_LINK = "//a[@href='%s' and text()='%s']";
	public static final String LEAVE_CONFIRM = "//button[text()='Leave Page']";
	public static final String LOADING_BAR = "//span[@class='loading-text' and contains(text(),' Please wait...')]";
	public static final String DYNAMIC_INPUT_TEXTBOX = "//input[@id=\"%s\"]";
	public static final String DYNAMIC_INPUT_TEXTAREA = "//textarea[@id='%s']";
	// public static final String SMART_SEARCH_VENDOR_LIST =
	// "//*[contains(@id,'ui-id')]/a";
	// public static final String SMART_SEARCH_TEXTBOX_LIST =
	// "//ul[contains(@id,'ui-id')]/li/a";
	public static final String SMART_SEARCH_LIST = "//li[contains(@id,'ui-id')]/a";
	public static final String DYNAMIC_ICON = "//span[@id='%s']";

	public static final String DYNAMIC_PAGE = "//a[@page='%s']";
	public static final String GET_DATA_DYNAMIC_COLUMN = "//tr[contains(@class,'odd') or contains(@class,'even')]/td[%s]";
	public static final String ENABLE_NEXT_PAGE = "//a[@class='paginate_button next' and text()='Next']";
	public static final String DYNAMIC_BUTTON = "//*[@id='%s']";
	public static final String DYNAMIC_LABEL = "//*[@id='%s']";
	public static final String DYNAMIC_NUMBER_OF_COLUMN = "//*[@id='%s']/tbody/tr[1]/td";

	public static final String DYNAMIC_SELECTED_RECORD = "//td[contains(text(),'%s')]";
	public static final String DYNAMIC_CONTEXT_MENU = "//a[text()='%s']";
	public static final String DYNAMIC_SCREEN_NAME = "//div[text()='%s']";
	public static final String DYNAMIC_POPUP_INFOR = "//*[@id='info-window-table']//span[text()='Trade Allowance']";
	public static final String DYNAMIC_TOOLTIP = "//span[@title=\"%s\"]";
	public static final String DYNAMIC_TEXT_LABEL = "//label[text()='%s']";
	public static final String DYNAMIC_LABEL_INPUT = "//span[@class='%s']";
	public static final String DYNAMIC_LABEL_VALUE = "//span[contains(text(),'%s')]";
	
	public static final String DROP_DOWN_LIST = "//*[@id='item-bar']/div/div/div/button";
	public static final String DYNAMIC_DROP_DOWN_CLICK = "//button[@data-id='%s']";
	public static final String DYNAMIC_DROP_DOWN_ICON_TEXTBOX = "//div[@id='%s']/div[@class='wrap-caret']";
	public static final String DYNAMIC_DROP_DOWN_VALUE_TEXTBOX = "//a[text()='%s']";
	public static final String DYNAMIC_DROP_DOWN_ICON_SMART_SEARCH = "//input[@id='%s']/following-sibling::div";
	public static final String DYNAMIC_DROP_DOWN_VALUE = "//span[@class='text' and contains(text(),'%s')]";

}
