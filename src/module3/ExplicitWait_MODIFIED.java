package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_MODIFIED {

	public static void main(String[] args) {

		// Open browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open AUT
		driver.get("http://seleniumautomationpractice.blogspot.com/2017/10/waitcommands.html");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Note: In this statement, we will get run-time exception of an NoSuchELement found, and program terminates.
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LinkText-6"))).click();
		
	
		//Catching an exception if there any, hence program will continue
		try {
			//
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LinkText-6"))).click();
		} catch (Exception e) {
			//Print the stackTrace.  
			e.printStackTrace();
		}
	
		System.out.println("End of program...");
		driver.quit();
	
	}
}
