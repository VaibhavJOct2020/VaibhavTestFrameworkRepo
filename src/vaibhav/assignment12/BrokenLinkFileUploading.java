package vaibhav.assignment12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vaibhav.base.Driver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinkFileUploading {	

	private static WebDriver driver;

	static void findBrokenLinks() throws IOException {
		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		for (int index = 0; index < linkList.size(); index++) {
		WebElement element = linkList.get(index);
		System.out.println("responses for links " + element.getText());
		String link = element.getAttribute("href");
		if (link != null && !link.isEmpty()) {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
				System.out.println("Link for " + element.getText() + " is not responding with Code" + " : " + responseCode);
				} else
					System.out.println("Link for " + element.getText() + " is working fine with code" + " : " + responseCode);
				} else
					System.out.println("Link is missing for " + element.getText());
		}
	}

	 void fileUploadKeyBoard() throws AWTException, InterruptedException {
		String filePath = "C:\\Users\\vaibhav\\debug.txt";
		System.out.println("Go to http://automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		System.out.println("Navigating to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Clicking on choose file button");
		WebElement element = driver.findElement(By.xpath("//input[@id = 'exampleInputFile']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
		
		Thread.sleep(3000);
		
		StringSelection se = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se, null);
		
		System.out.println("pressing enter key");
		Robot ro = new Robot();
		
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("TC is Passed ");
	}

	public static void main(String[] arg) throws IOException, AWTException, InterruptedException {
		BrokenLinkFileUploading brokenLinkFileUploading = new BrokenLinkFileUploading();
		System.out.println("Step 1 : Verifying broken links using HTML response codes");
		driver = Driver.start("D:\\TechnoCredits\\OCT20-Eclipse Programs\\Selenium_OCT20\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");
		/*BrokenLinkFileUploading.findBrokenLinks();
		System.out.println("");
		System.out.println("Step 2: Validating file upload");*/
		brokenLinkFileUploading.fileUploadKeyBoard();
	}
}
