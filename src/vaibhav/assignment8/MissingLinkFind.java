package vaibhav.assignment8;

/*Assignment - 8 : Missing_Link & Multiwindow_Handle 

1. Print missing link button text
Note: use missing link form from resources folder*/


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vaibhav.base.Driver;

public class MissingLinkFind {

	public static void main(String[] args) {
		WebDriver driver =Driver.start("D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\MissingLink.html");
		List<WebElement> list=driver.findElements(By.tagName("a"));
		for (WebElement element : list) {
			if(element.getAttribute("href") == null || element.getAttribute("href").length()==0)
				System.out.println(element.getText());
		}
	}

}
