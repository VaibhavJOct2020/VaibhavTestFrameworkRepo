package vaibhav.assignment11;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import brijesh.base.Driver;

/*Assignment : 11 [Complete it before Monday EOD] 

AutomationByKrishna -> Demo Tables -> Employee Manager Table:

Q1) how many rows are there in the table ?
ans : 9

Q2) how many employees are there in the table ?
ans : 8

<table>
	<tr>
		<th> first name> </th>
	</tr>
	
	<tr>
		<td> Vaibhav </td>
	</tr>
	
</table> 

solution : 1

	int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
     
	for(int index=1;index<=totalRows;index++){
		sop(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
	}

solution2 : 
	HashSet<String> setOfEmployeeId = new HashSet<String>();
	List<WebElement> listOfElements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")); 

	for(WebElement element : listOfElements){
		if(!setOfEmployeeId.add(element.getText()))
			sop("Duplicate Employee Id is :- " + element.getText());
	}
	sop("Total Employees " + setOfEmployeeId.size()); // 8
	-----------------------------------------------

Q3 : how many managers we have  and print them?
ans : 3 [Set]

Q4 : how many depts we have and print them ?
ans : 4 [Set]

Q5: print dept name and number of employees in each dept.
ans : [Map]
     7001-Admin -> 2
     7002-Finance -> 2
	 7003-HR -> 2
	 7004-IT -> 3
	 
hint : word freq -> String str = "Hi Hello Hi Hi Techno Hi Hello Hi" [print freq of each word]

Q6: print the manager id having maximum employee reporting to him.
ans : 20205 -> 4 [Map , find max key]
hint : String str = "Hi Hello Hi Hi Techno Hi Hello Hi"	*/

public class EmployeeManagerData {
	static WebDriver driver ;

	private static void printData()  {
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("Q1 : how many rows are there in the table ?");
		List<WebElement> totalRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		System.out.println("Total Rows are " + totalRows.size());

		System.out.println("Q2 : how many employees are there in the table ?");
		List<WebElement> EmpRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[2]"));
		Set<String> EmployeeId = new LinkedHashSet<>();
		for (WebElement webElement : EmpRows) {
			EmployeeId.add(webElement.getText());
		}
		System.out.println("Total Employees are " + EmployeeId.size());

		System.out.println("Q3 : how many managers we have  and print them?");
		List<WebElement> ManagersRows = driver
				.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		Set<String> ManagerId = new LinkedHashSet<>();
		for (WebElement webElement : ManagersRows) {
			ManagerId.add(webElement.getText());
		}
		System.out.println("Managers are as follows" + ManagerId.size());
		System.out.print(ManagerId);

		System.out.println("Q4 : how many depts we have and print them ?");
		List<WebElement> DepartmentRows = driver
				.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		Set<String> Department = new LinkedHashSet<>();
		for (WebElement webElement : DepartmentRows) {
			Department.add(webElement.getText());
		}
		System.out.println("Departments are as follows " + Department.size());
		System.out.print(Department);

		System.out.println("Q5: print dept name and number of employees in each dept.");
		Map<String, Integer> Departmant = new LinkedHashMap<>();
		for (WebElement webElement : DepartmentRows) {
			String text = webElement.getText();
			if (Departmant.containsKey(text))
				Departmant.put(text, Departmant.get(text) + 1);
			else
				Departmant.put(text, 1);
		}
		System.out.println("Department name and numbers are" +Departmant);

		System.out.println("\nQ6: print the manager id having maximum employee reporting to him.");
		Map<String, Integer> mapOfManager = new LinkedHashMap<>();
		for (WebElement webElement : ManagersRows) {
			String text = webElement.getText();
			if (mapOfManager.containsKey(text))
				mapOfManager.put(text, mapOfManager.get(text) + 1);
			else
				mapOfManager.put(text, 1);
		}
		int maxValue = 0;
		String maxKey = null;
		for (String key : mapOfManager.keySet()) {
			if (mapOfManager.get(key) > maxValue) {
				maxValue = mapOfManager.get(key);
				maxKey = key;
			}
		}
		System.out.println(maxKey + "::" + mapOfManager.get(maxKey));
		
	}

	public static void main(String[] args) {
		driver = Driver.start();
		try { 
			EmployeeManagerData.printData();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
