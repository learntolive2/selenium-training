package module4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sAlert {

	public static void main(String[] args) throws InterruptedException {

		// Open browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2018/01/blog-post.html");
		
		driver.findElement(By.id("alert")).click();
		
		//Call the  Alert Interface and switch to the Alert
		Alert sA = driver.switchTo().alert();
		
		//Print the text of the Alert
		System.out.println(sA.getText());
		
		Thread.sleep(2000);  //To show actual alert
		
		//Click on OK button of the ALert
		sA.accept();
		
		driver.quit();
		
	}

}
