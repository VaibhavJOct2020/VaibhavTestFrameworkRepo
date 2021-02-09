package vaibhav.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAlertDemo {
	
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

	public static void main(String[] args) {
		start();
		System.out.println("Step 1: Clicking on Basic Elements link");
		driver.findElement(By.linkText("Basic Elements")).click();
		String firstName = "vaibhav";
		String lastName = "jagtap";
		String companyName = "techno";
		System.out.println("Step 2: Enter first name");
		driver.findElement(By.name("ufname")).sendKeys(firstName);
		System.out.println("Step 3: Enter last name");
		driver.findElement(By.name("ulname")).sendKeys(lastName);
		System.out.println("Step 4: Enter company name");
		driver.findElement(By.name("cmpname")).sendKeys(companyName);
		System.out.println("Step 5: Click on submit");
		driver.findElement(By.xpath("//header[contains(text(),'Alert Demo')]//parent::section//button")).click();
		Alert alert = driver.switchTo().alert();
		String alertMessage=alert.getText();
		alert.accept();
		System.out.println("Step 6: Validate alert text");
		if(alertMessage.equals(firstName + " and " + lastName + " and " + companyName))
			System.out.println("Test Passed");
		else
			System.err.println("Test Failed");
	}
}
