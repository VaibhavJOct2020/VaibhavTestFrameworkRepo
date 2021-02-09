package vaibhav.assignment17;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vaibhav.base.Driver;

public class FramesH {
	static WebDriver driver ;
	
	private static void validatingFrames() throws InterruptedException {
		driver.findElement(By.cssSelector("a#iframes")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("site1");//switching on 1st frame by name and validating
		String actual=driver.findElement(By.xpath("//strong[contains(text(),'BLACK LIVES MATTER')]")).getText();
		if(actual.equals("BLACK LIVES MATTER"))
			System.out.println("successfull switched to frame1");
		else
			System.out.println(" check frame1");
		Thread.sleep(3000);
		driver.switchTo().frame(2);//switching to third frame by webelement
		String title = driver.getTitle();
		if(title.contains("Ant.apache"))
			System.out.println("successfull switched to frame3");
		else
			System.out.println(" check frame3");
	}


	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hi");
		driver =Driver.start();
		FramesH.validatingFrames();		
	}
}
