package vaibhav.assignment8;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import vaibhav.base.Driver;

public class WindowHandling {
	static WebDriver driver;
	
	private static void verifyNewWindow() throws Exception{
		System.out.println("Verify that by click on any button on form new window is opening");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Third Window']")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String newWindow : windows) {
			if(!mainWindow.equals(newWindow)) {
				driver.switchTo().window(newWindow);
				Thread.sleep(3000);//added this for observing that new opened window is getting closed
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());		
	}

	public static void main(String[] args) throws Exception {
		driver = Driver.start("D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\Window_Handling_Form.html");
		WindowHandling.verifyNewWindow();

	}
}
