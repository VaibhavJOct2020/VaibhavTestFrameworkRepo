package vaibhav.assignment14;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
/*Assignment 14
Form: Enable_And_Disable_Display_Hide_Form
Script 1: check element's clickability using explicit wait 
Script 2: check element's visibility using explicit wait
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vaibhav.base.Driver;

public class ExplicitWaitTesting {
	static WebDriver driver ;

	private static void waitTesting() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Enable & Disable Button']"))).click();
		WebElement inputElement = driver.findElement(By.xpath("//input[@id='myText']"));
		try{
			wait.until(ExpectedConditions.visibilityOf(inputElement)).sendKeys("Hi");
		}
		catch (ElementNotInteractableException e) {
			System.out.println("element is disabled so not able to use sendKeys");
		}
		
	}

	public static void main(String[] args) {
		String url = "D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html";
		driver = Driver.start(url);
		ExplicitWaitTesting.waitTesting();
	}
}
