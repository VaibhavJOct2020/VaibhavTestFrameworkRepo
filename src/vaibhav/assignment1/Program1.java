package vaibhav.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment - 1:
  
Write a program to cover below methods.

a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit()
 */


public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		String url = driver.getCurrentUrl();
		System.out.println("Current URl is "+url);
		String title = driver.getTitle();
		System.out.println("Current title is "+title);
	    String pageSource= driver.getPageSource();
	    System.out.println("Current PageSource is "+pageSource);
	    //driver.close();
	    driver.get("https://www.gmail.com");
	    driver.get("https://www.google.com");
	    driver.quit();
	    System.out.print("TC passed");
	}

}
