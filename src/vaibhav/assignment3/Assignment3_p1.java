package vaibhav.assignment3;


/*Program - 1 : Verify alert message on Registration Page -> login.*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3_p1 {
	
	private static WebDriver driver;

	private static void checkLogin(String userName, String passWord, String message) {
		System.out.println("Entering Username");
		WebElement webelementUsername=driver.findElement(By.xpath("//input[@id='unameSignin']"));
		webelementUsername.clear();
		webelementUsername.sendKeys(userName);
		System.out.println("Entering password");
		WebElement webelementPassword=driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		webelementPassword.clear();
		webelementPassword.sendKeys(passWord);
		System.out.println("clicking submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		alert.accept();
		if(alertText.contains(message))
			System.out.println("TC is passed");
		else
			System.out.println("TC is failed");		
	}
	
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

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start the browser and launch the URL");
		start();
		System.out.println("Clicking on Registration link");
		driver.findElement(By.xpath("//*[text()='Registration']")).click();
		System.out.println("Validate first user");
		Assignment3_p1.checkLogin("vaibhav","12","Failed! please enter strong password");
		System.out.println("Validate Second user");
		Assignment3_p1.checkLogin("maulik.kanani", "yuijhu", "Failed! please enter strong password");
		System.out.println("Validate Third user");
		Assignment3_p1.checkLogin("mkanani", "mk12312312", "Success!");
	}

}
