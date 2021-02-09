package vaibhav.exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vaibhav.base.Driver;

public class ValidateUsername {
	static WebDriver driver;
	
	public static void verifyUsername() {
		boolean flag = true;
		List<String>shortNameList = new ArrayList<String>();
		List<String>userNameList = new ArrayList<String>();
		driver.findElement(By.linkText("Demo Tables")).click();
		int tableRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int i = 1; i<=tableRows; i++) {
			WebElement elementname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]"));
			String name = elementname.getText().toLowerCase();
			String shortName =""+name.charAt(0);
			System.out.println(shortName);
			WebElement elementLastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]"));
			String lastName = elementLastName.getText().toLowerCase();
			System.out.println(lastName);
			shortName += lastName;
			shortNameList.add(shortName);
			WebElement elementUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[4]"));
			String userName = elementUserName.getText();
			userNameList.add(userName);
		}
		System.out.println(shortNameList);
		System.out.println(userNameList);
		for (int i = 0 ;i < shortNameList.size();i++) {
			if(shortNameList.size() != userNameList.size())
				System.out.println("both list are not of same size please check the data");
			else{
				if(shortNameList.get(i)!=userNameList.get(i))
					flag = false;
			}
		}
		if (flag)
			System.out.println("information is correct");
		else
			System.out.println("information is not correct");
	}

	public static void main(String[] args) {
		driver = Driver.start();
		ValidateUsername.verifyUsername();
	}
}
