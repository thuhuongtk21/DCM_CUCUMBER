package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

//import commons.Constant;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class AbstractTest extends AbstractPage{
	WebDriver driver;
	
	public AbstractTest(WebDriver driver_) {
		this.driver = driver_;
	}
	
	protected WebDriver openMultiBrowser(String browser, String version, String url) {
		  /*if(browser.equals("firefox")) {
			  driver = new FirefoxDriver();
		  }else if(browser.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }else {
			  System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
		  }*/
		  
		  if(browser.equals("firefox")) {
			  FirefoxDriverManager.getInstance().setup();
			  driver = new FirefoxDriver();
		  }else if(browser.equals("chrome")) {
			  ChromeDriverManager.getInstance().version(version).setup();
			  driver = new ChromeDriver();
		  }else {
			  InternetExplorerDriverManager.getInstance().version(version).setup();
			  driver = new InternetExplorerDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.get(Constant.URL);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;
	  }
	  protected int randomNumber() {
			Random random = new Random();
			int number = random.nextInt(999999);
			return number;
		}
	  
	  public String formatDateTime(String date, String dateType) throws Exception {	
		  Date input_dateTime_Parse = null;
		  SimpleDateFormat input_dateTime_Format = null;
		  SimpleDateFormat simpleFormat_dt = null;
		  switch (dateType) {
			case "@ yyyy-MM-dd HH:mm:ss":
				input_dateTime_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				input_dateTime_Parse = input_dateTime_Format.parse(date);
				simpleFormat_dt = new SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss");
				System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
				System.out.println("SimpleDateFormat =" +simpleFormat_dt);
				break;
			case "yyyy-MM-dd HH:mm:ss":
				input_dateTime_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				input_dateTime_Parse = input_dateTime_Format.parse(date);
				simpleFormat_dt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
				System.out.println("SimpleDateFormat =" +simpleFormat_dt);
				break;
			case "yyyy-mm-dd":
				input_dateTime_Format = new SimpleDateFormat("yyyy-mm-dd");
				input_dateTime_Parse = input_dateTime_Format.parse(date);
				simpleFormat_dt = new SimpleDateFormat("mm-dd-yyyy");
				System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
				System.out.println("SimpleDateFormat =" +simpleFormat_dt);
				break;
			case "/yyyy-mm-dd":
				input_dateTime_Format = new SimpleDateFormat("yyyy-mm-dd");
				input_dateTime_Parse = input_dateTime_Format.parse(date);
				simpleFormat_dt = new SimpleDateFormat("mm/dd/yyyy");
				System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
				System.out.println("SimpleDateFormat =" +simpleFormat_dt);
				break;
				
			}
			return simpleFormat_dt.format(input_dateTime_Parse).toString();
	  }
	  
	  protected boolean verifyPassed(boolean condition, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertTrue(condition);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }  
		  } else {
			  Assert.assertTrue(condition);
		  }
		  
		  return pass;
	  }
	  
	  public boolean verifyTrue(boolean condition) {
		  return verifyPassed(condition, false);
		  
	  }
	  
	  protected boolean verifyFailed(boolean condition, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertFalse(condition);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }  
		  } else {
			  Assert.assertFalse(condition);
		  }
		  
		  return pass;
	  }
	  
	  private boolean verifyEquals(Object actual, Object expected, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertEquals(expected, actual);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }
			  
		  }else {
			  Assert.assertEquals(expected, actual);
		  }
		  return pass;
		  
	  }
	  
	  public boolean verifyEquals(Object actual, Object expected) {
		  return verifyEquals(actual, expected, false);
		  
	  }
	  
	  private boolean verifyContains(Object actual, Object expected, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {				  
				  Assert.assertSame(expected, actual);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }
			  
		  }else {
			  Assert.assertEquals(expected, actual);
		  }
		  return pass;
		  
	  }
	  
	  public boolean verifyContains(Object actual, Object expected) {
		  return verifyContains(actual, expected, false);
		  
	  }
	  
	  protected void closeBrowser(WebDriver driver) {
		  try {
			  String osName = System.getProperty("os.name").toLowerCase();
			  String cmd = "";
			  driver.quit();
			  if(driver.toString().toLowerCase().contains("chrome")) {
				  if(osName.toLowerCase().contains("mac")) {
					  cmd = "pkill chromedriver";
				  }else {
					  cmd = "taskkill /IM chromerdriver.exe /F";
				  }
				  Process process = Runtime.getRuntime().exec(cmd);
				  process.waitFor();
			  }
			  if(driver.toString().toLowerCase().contains("internetexplorer")) {
				  cmd = "taskkill /IM IEDriverServer.exe /F";
				  Process process = Runtime.getRuntime().exec(cmd);
				  process.waitFor();
			  }
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
		  
	  }
	  
	  
	  
	  

}