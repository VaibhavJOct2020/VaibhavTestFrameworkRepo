package vaibhav.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Program - 2: Go to Basic element page, 
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button*/


public class VerfiyAlert {
	private static WebDriver driver;
	
	public static WebDriver start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully.");
		return driver;		
	}
	
	private static void firstAlert() {
		String message = "TechnoCredits";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.id("javascriptAlert")));
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		if (alertMessage.contains(message)) 
			System.out.println("TC 1 is passed");
		else
			System.out.println("TC 1 is failed");
	}

	private static void javascriptConfirmation() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='Javascript Confirmation']")));
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String choiceMessage=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		if (choiceMessage.contains("Cancel")) 
			System.out.println("TC 2 is passed");
		else
			System.out.println("TC 2 is failed");		
	}

	private static void javaScriptPrompt() {
		String name = "vaibhav";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='Javascript Prompt']")));
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		String choiceMessage=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		if (choiceMessage.contains(name)) 
			System.out.println("TC 3 is passed");
		else
			System.out.println("TC 3 is failed");		
	}

	public static void main(String[] args) throws InterruptedException {
		VerfiyAlert.start();
		System.out.println("clicking on Basic Element");
		driver.findElement(By.xpath("//*[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		System.out.println("Executing Alert 1");
		VerfiyAlert.firstAlert();
		System.out.println("Alert 1 Completed");
		System.out.println("Executing Alert 2");
		VerfiyAlert.javascriptConfirmation();
		System.out.println("Alert 2 Completed");
		System.out.println("Executing Alert 3");
		VerfiyAlert.javaScriptPrompt();
		System.out.println("Alert 3 Completed");
	}

}
