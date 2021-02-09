package vaibhav.assignment6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PropertyFile {
	
	static WebDriver driver;
	
	public static WebDriver start(String url) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully.");
		return driver;
	}

	private static void fillingForm() throws IOException {
		File file = new File ("./src/vaibhav/assignment6/config.properties");
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(file);
		property.load(fis);
		String uname = property.getProperty("firstname");
		System.out.println("enter fist name");
		WebElement fnameElement=driver.findElement(By.xpath("//*[contains(@id,'first name')]"));
		fnameElement.sendKeys(uname);
		
		System.out.println("enter Last name");
		WebElement lnameElement=driver.findElement(By.xpath("//*[contains(@id,'last name')]"));
		lnameElement.sendKeys(property.getProperty("lastname"));
		
		System.out.println("enter email");
		WebElement emailElement=driver.findElement(By.xpath("//*[contains(@id,'E-mail')]"));
		emailElement.sendKeys(property.getProperty("email"));
		
		System.out.println("enter company name");
		WebElement cmpElement=driver.findElement(By.xpath("//*[contains(@id,'Company Name')]"));
		cmpElement.sendKeys(property.getProperty("companyname"));
		
		WebElement genderElement=driver.findElement(By.xpath("//*[contains(@value,'female')]"));
		genderElement.click();
		
		System.out.println("enter region");
		WebElement regionElement=driver.findElement(By.xpath("//*[contains(@name,'continents')]"));
		Select select = new Select(regionElement);
		select.selectByVisibleText("North America");
		
		System.out.println("enter experience");
		WebElement expElement=driver.findElement(By.xpath("//*[contains(@id,'intermidiate')]"));
		expElement.click();		
		
		System.out.println("enter known language");
		WebElement langElement=driver.findElement(By.xpath("//*[contains(@id,'knownlanguage')]"));
		langElement.sendKeys(property.getProperty("knownlanguage"));
		
		WebElement learlangElement=driver.findElement(By.xpath("//*[text()='Java']"));
		learlangElement.click();
		
		WebElement dreamCompElement=driver.findElement(By.xpath("//*[contains(@id,'google')]"));
		dreamCompElement.click();
		
		System.out.println("Accepting conditions");
		WebElement acceptCondition=driver.findElement(By.xpath("//*[contains(@id,'confirmDetails')]"));	
		acceptCondition.click();
		
		System.out.println("clicking Go and Practice");
		WebElement practice=driver.findElement(By.linkText("Go And Practice For it"));
		practice.click();
		
		driver.navigate().back();
		try {
			String str = fnameElement.getAttribute("value");
			if(str.length() == 0)
				System.out.println("values are not retaining in firstname textbox");
		}catch (StaleElementReferenceException sere) {
			System.out.println("stale element found");
			System.out.println("values are not retaining in firstname textbox");
		}		
	}
		

	public static void main(String[] args) {
		String url = "D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html";
		start(url);		
		try {
			PropertyFile.fillingForm();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
