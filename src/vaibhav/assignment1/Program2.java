package vaibhav.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*b) navigation cmd:
    1) void navigate().to(String url)
    2) void navigate().forward()
    3) void navigate().back()
    4) void navigate().refresh()*/


public class Program2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("navigate forward action doesn't give any error when forward arrow is not present on UI");
		driver.navigate().refresh();
		System.out.println("page is refreshing");
		driver.navigate().back();
		System.out.println("back is working fine absoutely");
		
		
	}
}
