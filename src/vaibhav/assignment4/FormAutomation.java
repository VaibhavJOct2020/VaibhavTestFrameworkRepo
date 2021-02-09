package vaibhav.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import vaibhav.base.Driver;
/*
a) Revert the selection of 'Gender' radio button.
	Example: If 'Male' is preselected then select 'Female'.
			 If 'Female' is preselected then select 'Male'.
		 
b) Revert the selection of checkboxes under 'language Wanted to learn'
	Example: Whatever language is selected in checkboxes, please uncheck those 
			 & Select unchecked checkboxes
			 
c) Select 'Second Last' index from 'I am living in' dropdown and print value of selected option.
	Note: This is dynamic dropdown. Options may get changed in future. So don't search it by name. 
		  We want second last index in any situation
		  
d) Validate 'Total Year's of Experience In Industry' radio button.
	Print message like below based on preselected experience radio button. 
	1. Student -> print 'Beginner'
	2. 1-3 -> print 'Upper Beginner'
	3. 3-6 -> print 'Intermediate'
	4. 6-10 -> print 'Advanced'
	5. Above 10 -> print 'Expert'
	
e) Validate Reset functionality of form.
	1. Type something in 'First Name'. Validate text of this field.
	2. Click on 'Reset form in same tab' button.
	3. Validate text of 'First Name' field again. It should be empty or null.
*/
public class FormAutomation {
	private static void numberOfExperience(WebElement noOfExperience) {
		noOfExperience.click();
		String id =noOfExperience.getAttribute("id");
		System.out.println("Candidate is "+id);		
	}

	public static void main(String[] args) {
		String url = "D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html";
		WebDriver driver = Driver.start(url);
		System.out.println("Reverting the selection of 'Gender' radio button."); //a
		if (driver.findElement(By.xpath("//*[@value='male']")).isSelected())
			driver.findElement(By.xpath("//*[@value='female']")).click();
		else 
			driver.findElement(By.xpath("//*[@value='male']")).click();
		
		System.out.println("Reverting the selection of language Wanted to learn"); //b		
		WebElement javaLanguage = driver.findElement(By.id("java"));
		WebElement pythonLanguage = driver.findElement(By.id("python"));
		WebElement javaScriptLanguage = driver.findElement(By.id("javascript"));
		
		if (javaLanguage.isSelected()) {
			System.out.println("Java is selected so changing to python and java script");
			javaLanguage.click();
			pythonLanguage.click();
			javaScriptLanguage.click();
		}
		else if(pythonLanguage.isSelected()) {
			System.out.println("python is selected so changing to java and java script");
			pythonLanguage.click();
			javaLanguage.click();
			javaScriptLanguage.click();			
		}
		else {
			System.out.println("JavaScript is selected so changing to java and Python");
			javaScriptLanguage.click();
			javaLanguage.click();
			pythonLanguage.click();			
		}
		
		System.out.println("Validating 'Total Year's of Experience In Industry'"); //c
		WebElement continents = driver.findElement(By.name("continents"));
		Select select = new Select (continents);
		List<WebElement> region =select.getOptions();
		WebElement secondLastIndex = region.get(region.size()-2);		
		System.out.println("'Second Last index from I am living in is "+ secondLastIndex.getText());
		
		System.out.println("fetching the Experience"); //d
		WebElement beginnerWebElement = driver.findElement(By.id("student"));
		WebElement upperBeginnerWebElement = driver.findElement(By.id("beginner"));
		WebElement intermediateWebElement = driver.findElement(By.id("entry"));
		WebElement advancedWebElement = driver.findElement(By.id("intermidiate"));
		WebElement expertWebElement = driver.findElement(By.id("expert"));		
		FormAutomation.numberOfExperience(upperBeginnerWebElement);	//please use this and send the experience from here
		
		System.out.println("Validate Reset functionality of form.");//e
		WebElement element = driver.findElement(By.id("first name"));
		element.sendKeys("Vaibhav");
		if (element.getAttribute("value").contains("Vaib")) {
			String tempText = element.getAttribute("value");
			System.out.println("Value present before deleting "+tempText);
			System.out.println("Clicking on form reset button");
			driver.findElement(By.id("resetBtn")).click();
			String presentText = element.getAttribute("value");
			System.out.println(presentText);
			if (presentText == null || presentText.length() == 0 || presentText == "")
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		}		
	}
}
