package vaibhav.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	protected static WebDriver driver;
	
	public static void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		System.out.println("website open successfully.");
	}
	
	public static void close() {
		driver.close();
	}
}
