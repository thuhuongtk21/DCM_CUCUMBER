package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.CommonPageUI;
import pages.DealBuilderPagePO;
import pages.OfferAccpetPO;
import pages.OfferCreatePO;
import pages.OfferMaintainPO;
import pages.OfferReviewPO;
import pages.OfferSearchPO;
import pages.PageFactoryManager;

public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);

	}

	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	
	
	public void moveAndClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		System.out.println("Click to element " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);

	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String text) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(text);

	}

	public void sendKeyToElement(WebDriver driver, String locator, String text, String... value) {
		locator = String.format(locator, (Object[]) value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(text);

	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);

	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();

	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);

	}
	
	public String getAttributeValue(WebDriver driver, String locator, String value, String attribute) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);

	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();

	}
	
	public String getTextElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();

	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();

	}
	
	public int getSizeElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();

	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void checkTheCheckbox(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}

	}

	public void uncheckTheCheckbox(WebDriver driver, String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}

	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();

	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();

	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();

	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();

	}

	public void getListElementWithOneDynamicvalue(WebDriver driver, String locator, String value) {
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		for (WebElement element : elementList) {
			if (element.getText().contains(value)) {
				System.out.println("Selected element = " + element.getText());				
				element.click();
				System.out.println("Click on element = " + element.getText());
			}
		}

	}

	public void getListElementWithTwoDynamicvalue(WebDriver driver, String locator, String value1, String value2) {
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		for (WebElement element : elementList) {
			if (element.getText().contains(value1) && element.getText().contains(value2)) {
				element.click();
				break;
			}
		}

	}

	public void clickOnPageNumber(WebDriver driver, String locator, int value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void getListItemOnOnePage(WebDriver driver, String locator, String value, List<String> addToFinalList) {
		List<String> addSearchResultToList = new ArrayList<String>();
		
		locator = String.format(locator, value);
		
		List<WebElement> resultList = driver.findElements(By.xpath(locator));
		for (WebElement resultItem : resultList) {
			String getItemOnRow = resultItem.getText();
			addSearchResultToList.add(getItemOnRow);
		}
		addToFinalList.addAll(addSearchResultToList);
	}
	
	public void getListItemOnOnePage_SpecificList(WebDriver driver, String locator, String value) {
		List<String> addSearchResultToList = new ArrayList<String>();
		List<String> addToColumnList =  new ArrayList<String>();
		
		locator = String.format(locator, value);
		
		List<WebElement> resultList = driver.findElements(By.xpath(locator));
		for (WebElement resultItem : resultList) {
			String getItemOnRow = resultItem.getText();
			addSearchResultToList.add(getItemOnRow);
		}

		addToColumnList.addAll(addSearchResultToList);
		System.out.println("Add to column list = "+ addToColumnList);
		
	}
	
	/*public void getListItemOnOnePage_Test(WebDriver driver, String locator, int value, List<String> addToFinalList) {
		List<String> addSearchResultToList = new ArrayList<String>();
		
		locator = String.format(locator, value);
		
		List<WebElement> resultList = driver.findElements(By.xpath(locator));
		for (WebElement resultItem : resultList) {
			String getItemOnRow = resultItem.getText();
			addSearchResultToList.add(getItemOnRow);
		}
		addToFinalList.addAll(addSearchResultToList);
	}*/
	
	

	

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

	}

	public void switchdToWindowById(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);

	}

	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}
	
	public void hoverMouse(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}
	
	public void rightClick(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void drapAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();

	}

	public void keyPress(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.ENTER);

	}
	
	public void dynamicEnterKeyPress(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.ENTER).perform();

	}
	
	public void dynamicTabKeyPress(WebDriver driver, String locator, String value ) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.TAB).perform();

	}

	public void upload(WebDriver driver, String locator, String filePath) {
		WebElement element = driver.findElement(By.xpath(locator));

		element.sendKeys(filePath);

	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickForWebElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object srollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].style.border='2px groove green'", element);
	}

	public void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px groove green'", element);
	}

	public void removeAttributeNameOfElement(WebDriver driver, WebElement element, String attributeName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);

	}

	/*
	 * public boolean checkAnyImageLoaded(WebDriver driver, WebElement image) {
	 * JavascriptExecutor js = (JavascriptExecutor) driver; return (boolean)
	 * js.executeScript("return arguments[0].complete &&" +
	 * "typeof arguments[0].naturaWidth != 'undefined' && arguments[0].naturaWidth > 0"
	 * , image); }
	 */

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	public void waitForControlVisible(WebDriver driver, String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	public void waitForControlInvisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void clickOnLeaveConfirmationPopupWeb(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();

	}
	
	/*Connect to DB*/
	  protected static Connection connectToDatabase() throws ClassNotFoundException, SQLException {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection connection = DriverManager.getConnection("jdbc:db2://RDZUT01.HEB.COM:446/DB2R", "SVCT_DCM",
					"p9rty28j");

			System.out.println("Connect succesfully");
			return connection;
		}
	
	public String formatSQL(String query, String schema, String tableName, String columnName, String value) {
		  query = String.format(query, schema,tableName, columnName, value );
		  return query;
	}
	
	public String formatSQLFromAndWhere(String query, String database) {
		  query = String.format(query, database);
		  return query;
	}
	
	
	
	
	  

}
