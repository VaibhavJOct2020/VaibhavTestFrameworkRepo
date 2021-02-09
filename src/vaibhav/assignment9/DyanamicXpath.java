package vaibhav.assignment9;

import java.util.HashSet;

/*Assignment 9
Q1 : How many rows are there in Employee Basic Information Table.
-->  List<WebElement> listOfRows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
     listOfRows.size();

	 
Q2 : print last name of the employee whoes first name is 'Dhara'.
--> 

Q3 - A: print count of columns in the employee Basic Information table.
--> findElements : //table[@id='table1']/thead/tr/th


Q3 - B: print all column name of the employee Basic Information table.
--> List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
	for(WebElement element : allColumns){
		Sop(element.getText());
	}

Q4: generic function to get column index of any column.
--> int getColIndex(String colName){ // username
		int totolCol = driver.findElements("//table[@id='table1']//th").size();
		for(int colIndex=1;colIndex<=totolCol;colIndex++){
			String currentCol = driver.findElement("//table[@id='table1']//th["+colIndex+"]").getText();
			if(currentCol.equals(colName))
				return colIndex;
		}
		return -1;
	}

Q5 -a : print first row of Employee basic table
--> 
	int temp = 10;
	"Maulik" + temp + "Kanani"
	int totalColumn = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
	for(int index=1;index<=totalColumn;index++){
		String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td["+index+"]")).getText();
		sop(text);
	}
	
	
Q5 - b : print all rows of Employee basic table
--> int totolRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

for(int rowIndex=1;rowIndex<=totolRows;rowIndex++){
	int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td")).size();
	for(int colIndex=1;colIndex<=totalColumns;colIndex++){
		String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
		System.out.print(data + " ");
	}
	System.out.println();
}	

//table[@id='table1']/tbody/tr[2]/td[1]
//table[@id='table1']/tbody/tr[2]/td[2]
//table[@id='table1']/tbody/tr[2]/td[3]
//table[@id='table1']/tbody/tr[2]/td[4]

//table[@id='table1']/tbody/tr[3]/td[1]
//table[@id='table1']/tbody/tr[3]/td[2]
//table[@id='table1']/tbody/tr[3]/td[3]
//table[@id='table1']/tbody/tr[3]/td[4]

//table[@id='table1']/tbody/tr[4]/td[1]
//table[@id='table1']/tbody/tr[4]/td[2]
//table[@id='table1']/tbody/tr[4]/td[3]
//table[@id='table1']/tbody/tr[4]/td[4]


Q6: print username of all employees.
//table[id='id1']/tbody/tr["+index+"]/td[4]


Q7: print first name and last name of all employees.


Q8: find unique last name from table Employee Basic.


Q9: how many employees (rows) are there after "Dhara". 


//table[@id = 'table1']//tr[3]//following-sibling::tr
//table[@class='table']//td[text()='Dhara']//following-sibling::td[1]
//table[@id='table1']//td[text()='Dhara']//following-sibling::td[1]
//td[contains(text(),’Dhara’)]/following::td
//table[@id='table1']//thead//tr//th
*/

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vaibhav.base.Driver;

public class DyanamicXpath {
	
	static WebDriver driver;
	static Set <String>set = new HashSet<String>();

	private static int getColIndex(String colName) {
		int tableCols= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		for(int i = 1 ; i<= tableCols;i++ ) {
			String currentColName=  driver.findElement(By.xpath("//table[@id='table1']//th["+i+"]")).getText();
			if(currentColName.equals(colName))
			return i;
		}
		return -1;		
	}
	
	private static void findingXpath() {
		System.out.println("going to table section");
		driver.findElement(By.partialLinkText("Tables")).click();
		
		System.out.println("Q1 : How many rows are there in Employee Basic Information Table.");
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("size of rows in tbody "+tableRows.size());
		
		System.out.println("Q2 : print last name of the employee whoes first name is 'Dhara'.");
		WebElement lastName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Dhara']/following-sibling::td[1]"));
		System.out.println("Last name of Dhara is  "+lastName.getText());
		
		System.out.println("Q3 A: print count of columns in the employee Basic Information table.");
		List<WebElement> tableCols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("size of cols in table "+tableCols.size());
		
		System.out.println("Q3 - B: print all column name of the employee Basic Information table.");
		for (WebElement cols :  tableCols) {
			System.out.println(cols.getText());			
		}
		
		System.out.println("Q4: generic function to get column index of any column.");
		int currentIndex= getColIndex("Last Name");
		System.out.println(currentIndex);
		
		System.out.println("Q5 -a : print first row of Employee basic table");
		int totalCol = tableCols.size();
		for (int index = 1 ; index <= totalCol;index++ ) {
			String details = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td["+index+"]")).getText();
			System.out.print(" "+details);
			System.out.println();
		}
				
		System.out.println("Q5 - b : print all rows of Employee basic table");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1 ; index <= totalRows;index++ ) {
			for (int innerIndex = 1 ; innerIndex <= totalCol;innerIndex++ ) {
				String details = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+innerIndex+"]")).getText();
				System.out.print(" "+details);
				System.out.println();
			}			
		}
		
		System.out.println("Q6: print username of all employees.");	
		int totalRows1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1 ; index <= totalRows1;index++ ) {
			String uname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			System.out.print(" "+uname);
		}
		
		System.out.println("Q7: print first name and last name of all employees.");	
		for (int index = 1 ; index <= totalRows1;index++ ) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String lastName1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			System.out.println(firstName+" "+lastName1);				
		}
			
		System.out.println("Q8:find unique last name from table Employee Basic.");	
		for (int index = 1 ; index <= totalRows1;index++ ) {
			String lastName1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			set.add(lastName1);			
		}
		System.out.println(set);
		
		System.out.println("Q9:how many employees (rows) are there after \"Dhara\"");
		int totalEmployee = driver.findElements(By.xpath("//table[@id='table1']//td[text()='Dhara']/parent::tr/following-sibling::tr")).size();
		System.out.println("Employee After Dhara "+totalEmployee);
	}

	public static void main(String[] args) {
		driver = Driver.start();
		DyanamicXpath.findingXpath();		
	}

}
