package vaibhav.assignment13;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/*1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
2. Double Click on (AutomationByKrishna)
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import vaibhav.assignment14.ExplicitWaitTesting;
import vaibhav.base.Driver;

public class ActionClassMethods {
	
	static WebDriver driver;
	
	private static void mouseMethods() {
		Actions actions = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='droptarget']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("javascript:window.scrollBy(250,350)");
		actions.dragAndDrop(source, destination).build().perform();
		String refMsg = "You successfully double clicked it";
		driver.get("http://automationbykrishna.com");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Scrolling down to get element in view port");
		WebElement element = driver.findElement(By.linkText("Double-click on me"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",element);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		if(msg.equals(refMsg))
			System.out.println(msg);
		else
			System.out.println("Element is not double clicked at this time");
		alert.accept();
		driver.get("http://amazon.in");
		System.out.println("Hover mouse over Account & Lists");
		WebElement elementAmazon = driver.findElement(By.xpath("//a[@href ='https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&']"));
		Actions act = new Actions(driver);
		act.moveToElement(elementAmazon).build().perform();
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id = 'nav-al-container']//a[@class = 'nav-link nav-item']"));
		System.out.println("Number of links under Accounts & Lists are as follows");
		System.out.println(listOfLinks.size());
		
	}

	public static void main(String[] args) {
		String url = "https://demos.telerik.com/kendo-ui/dragdrop/index";
		driver = Driver.start(url);
		ActionClassMethods.mouseMethods();
	}
}
