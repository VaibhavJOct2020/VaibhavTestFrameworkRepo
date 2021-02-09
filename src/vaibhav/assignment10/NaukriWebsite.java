package vaibhav.assignment10;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import vaibhav.base.Driver;

public class NaukriWebsite { 
	static WebDriver driver;

	private static void closeAllWindows() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows= driver.getWindowHandles();
		for(String singleWindow : allWindows) {
			driver.switchTo().window(singleWindow);
			String currentTitle = driver.getTitle();
			if(!currentTitle.contains("Recruitment")){
				System.out.println("Closing the following url"+driver.getCurrentUrl());				
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		String title = driver.getTitle();
		System.out.println("main window "+title);
		if( title.contains("Recruitment"))
			System.out.println("Scenario Passed");
		else
			System.out.println("Scenario failed");		
	}

	public static void main(String[] args) {
		driver=Driver.start("https://www.naukri.com/");
		NaukriWebsite.closeAllWindows();
	}

}
