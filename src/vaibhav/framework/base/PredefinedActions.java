package vaibhav.framework.base;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import vaibhav.framework.exceptionhandling.InvalidLocatorType;
import vaibhav.framework.utils.TimeUtils;
//import org.apache.commons.io.FileUtils;

public class PredefinedActions {
	
	protected static WebDriver driver;
	private static WebDriverWait wait;
	
	public static void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,30);
		System.out.println("website open successfully.");
	}
	private String getlocatorType(String locator) {
		return locator.split("]:-")[0].substring(1);
		
	}
	private String getlocatorValue(String locator) {
		return locator.split("]:-")[1];
	}
	
	protected WebElement getElement(String locator,boolean isWaitRequired) {
		String locatorType = getlocatorType(locator);
		System.out.println(locatorType);
		String locatorValue = getlocatorValue(locator);
		System.out.println(locatorValue);
		WebElement element=null;
		switch(locatorType.toUpperCase()) {
			case "CSS":
				if(isWaitRequired)
					try {
						element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
					}
					catch(Exception e) {
						element=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
					}
				else
					element=driver.findElement(By.cssSelector(locatorValue));
				break;
			case "XPATH":
				if(isWaitRequired)
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				else
					element=driver.findElement(By.xpath(locatorValue));
				break;
			case "ID":
				if(isWaitRequired)
				try{
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				}
				catch(Exception e) {
					element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
				}
				else
					element=driver.findElement(By.id(locatorValue));
				break;
			case "NAME":
				if(isWaitRequired)
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				else
					element=driver.findElement(By.name(locatorValue));
				break;
			case "LINKTEXT":
				if(isWaitRequired)
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
				else
					element=driver.findElement(By.linkText(locatorValue));
				break;
			case "PARTIALLINKTEXT":
				if(isWaitRequired)
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
				else
					element=driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "TAGNAME":
				if(isWaitRequired)
					try{
						element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
					}catch(Exception e) {
						element=wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
					}
				else
					element=driver.findElement(By.tagName(locatorValue));	
				break;
			default:
				throw new InvalidLocatorType();
		}		
		return element;
	}
	
	protected void clickOnElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element)).click();
		}catch(Exception e) {			
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
	}
	
	protected void clickOnElement(String locator,boolean isWaitRequired) {
		WebElement clickableElement = getElement(locator, isWaitRequired);
		clickOnElement(clickableElement);
	}
	
	protected void checkOnElement(String locator,boolean isWaitRequired) {
		WebElement clickableElement = getElement(locator, isWaitRequired);
		clickableElement.click();		
	}	
	
	protected void checkOnElement(WebElement element) {
		element.click();		
	}
	protected void clearText(WebElement element) {
		element.clear();		
	}
	
	protected void enterText(WebElement element,String text) {
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(element));
		if(textElement.isEnabled()) {
			clearText(textElement);
			textElement.sendKeys(text);
		}
		else
			throw new ElementNotInteractableException("Element"+element+"is not interaactble");
	}
	
	protected void enterText(String locator,boolean isWaitRequired,String text) {
		WebElement element = getElement(locator, true);	
		enterText(element,text);
	}
	
	protected void scrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	protected boolean isElementDispalyed(WebElement element) {
		if(!element.isDisplayed()) {
			scrollToElement(element);
		}		
		return element.isDisplayed();	
	}
	
	protected String getElementText(WebElement element) {
		if(!element.isDisplayed()) {
			scrollToElement(element);
		}
		return element.getText();		
	}
	
	protected String getElementText(String locator,boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		return getElementText(element);				
	}
	
	public static void getScreenShot(String message) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/vaibhav/framework/screenshot/"+message+" "+TimeUtils.getTimeStamp()+".png");
		//File dest = new File("./src/vaibhav/framework/config/1.png");
		try {
			//Files.copy(src, dest);
			//FileUtils.
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			//System.out.println("Unable to copy the screen shot file");;
			e.printStackTrace();
		}		
	}
	
	public static void close() {
		driver.close();
	}
}
