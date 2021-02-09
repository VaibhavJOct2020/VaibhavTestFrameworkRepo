package vaibhav.assignment7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
/*----------------------------------------------
Assignment - 7 : Scroll & MultiSelect 

Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import vaibhav.base.Driver;

public class MultiSelect {
	
	private static WebDriver driver;

	private static void selectOption() throws Exception {
		System.out.println("Step2: Click on Basic Elements link");
		driver.findElement(By.linkText("Basic Elements")).click();

		System.out.println("Step3: select 1 and 3 value in a multi select dropdown");
		WebElement webElement = driver.findElement(By.xpath("//select[@multiple='']"));
		Select select = new Select(webElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");

		System.out.println("Step4: Verify both values get selected");
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		List<String> selectedOptionsText = new ArrayList<String>(selectedOptions.size());
		for (WebElement element : selectedOptions) {
			selectedOptionsText.add(element.getText());
		}
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1");
		expected.add("3");		
		if (selectedOptionsText.equals(expected)) {
			System.out.println("Step4 Passed");
		} else
			System.out.println("Step4 Failed");

		System.out.println("Step5: print all options which are not selected");
		List<WebElement> allavailableOptions = select.getOptions();
		allavailableOptions.removeAll(selectedOptions);
		for (WebElement element : allavailableOptions) {
			System.out.println(element.getText());
		}

		System.out.println("Step6: deselect all selected options");
		select.deselectAll();

		System.out.println("Step7: verify none of the options are selected now.");
		if (select.getAllSelectedOptions().size() == 0)
			System.out.println("Step 7 Passed");
		else
			System.out.println("Step 7 Failed");
		
	}

	public static void main(String[] args) {
		driver = Driver.start();
		try {
			MultiSelect.selectOption();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
