package vaibhav.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		System.out.println("Strp 1:-launch facebook");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println("Strp 2:-login with username");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("richvaibhav@yahoo.co.in");
		System.out.println("Strp 3:-login with passowrd");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("*******");
		System.out.println("Strp 4:-click on login button");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.close();
	}

}
