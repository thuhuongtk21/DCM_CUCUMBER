package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.CommonPageUI;
import interfaces.OfferSearchUI;

public class OfferSearchPO extends AbstractPage{
	WebDriver driver;
	
	public OfferSearchPO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	/*public void getListItemOfAllColumnsOnAllPages {
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
			int numerOfColumn = getSizeElement(driver, OfferSearchUI.NUMBER_OF_COLUMN);
			for(int value = 0; value < numerOfColumn; value ++) {
				getListItemOnOnePage_Test(driver, CommonPageUI.GET_DATA_DYNAMIC_COLUMN, value, addToFinalList);
			}
			

		} while (isControlDisplayed(driver, CommonPageUI.ENABLE_NEXT_PAGE));
	}*/

}
