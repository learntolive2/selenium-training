package module3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErrorValidation {

	public static void main(String[] args) throws InterruptedException {

		// Open Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/nlogin/login");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("usernameField")).click();
		
		driver.findElement(By.id("passwordField")).click();
		
		WebElement errmsg = driver.findElement(By.id("usernameField_err"));
		
		boolean ErrorMessage = errmsg.getText().equals("Email ID/Username cannot be left blank");
		
		System.out.println(ErrorMessage);
		
		driver.quit();
	}

}
