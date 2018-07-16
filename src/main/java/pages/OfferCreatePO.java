package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import interfaces.CommonPageUI;
import interfaces.OfferCreateUI;

public class OfferCreatePO extends AbstractPage{
	WebDriver driver;
	String vendorID, vendorType;
	
	public OfferCreatePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputDataForVendor() {
		
	}
	
	public void attachmentFile(String filePath, String fileName) {
		WebElement uploadFile = driver.findElement(By.xpath(OfferCreateUI.ATTACHMENT_ICON));
		uploadFile.sendKeys(filePath);
		waitForControlVisible(driver, OfferCreateUI.FILENAME);
		
	}
	
	
	
	

}
