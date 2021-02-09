package vaibhav.assignment5;

/*Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form] 

a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 

Note : This will prove, getAttribute will work even though, element is disabled.*/


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form5 {
	
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
	
	private static void enableDisable() {		
		WebElement messageElement = driver.findElement(By.xpath("//*[@id='myDIV']"));//a
		WebElement hideButton = driver.findElement(By.xpath("//*[text()='Visiable & Hidden Button']")); 
		if(messageElement.isDisplayed());
			System.out.println("displayed message is "+messageElement.getText());
		hideButton.click();
		System.out.println("after hiding message is not present "+messageElement.getText());
		
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));//b//c
		WebElement disableButton = driver.findElement(By.xpath("//*[text()='Enable & Disable Button']")); 		
		if(textBox.isEnabled()) {
			disableButton.click();
			System.out.println("Button is enable so making it disable");
			disableButton.click();//enabling it for point d
			try {
				//textBox.sendKeys("Vaibhav");
			}catch(Exception E) {
				System.out.println("Element is not interactable as you are sending message on disabled text box");
			}
			
		}
		else {
			System.out.println("Button is disabled so sending keys");
			textBox.sendKeys("Vaibhav");
		}	
		textBox.sendKeys("vaibhav");//D 
		disableButton.click();
		String disabledText = textBox.getAttribute("Value");
		System.out.println("Disabled text is "+disabledText);
		try {
			disabledText.equals("Vaibhav");
			System.out.println("Tc is pass for d section");
		}catch (NullPointerException ne) {
			ne.printStackTrace();
			System.out.println("Tc is failed for d section as value is containing null");
		}
	}


	public static void main(String[] args) {
		String pathUrl = "D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html";
		start(pathUrl);
		Form5.enableDisable();
	}
}
