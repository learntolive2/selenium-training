package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		
		//Instantiate Browser - Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Open the AUT
		driver.get("https://www.facebook.com/");
		
		/*
		//Locators
		//ID
		//driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.id("u_0_l")).sendKeys("Abhresh");
		
		//Name
		driver.findElement(By.name("lastname")).sendKeys("Sugandhi");
		driver.findElement(By.id("u_0_n")).clear();
		
		//Class Name
		driver.findElement(By.className("inputtext")).sendKeys("Abhresh");
		driver.findElement(By.className("inputtext")).sendKeys("Edureka");
		
		
		//LinkText
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		Thread.sleep(5000);
		
		driver.navigate().back();
				
		Thread.sleep(5000);
		
		//Partial LinkText
		driver.findElement(By.partialLinkText("n a")).click();
		
		//CSS
		driver.findElement(By.cssSelector("#u_0_q")).sendKeys("987654321");
		*/
		
		//Tag Name
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		
		
		
	}

}
