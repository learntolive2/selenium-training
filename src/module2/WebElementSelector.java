package module2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementSelector {

	public WebElementSelector() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		String CHROME_DRIVER = "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe";
		String AUT = "http://www.facebook.com";
		
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		WebDriver driver = new ChromeDriver();
		
		// Get commands
		driver.get(AUT);// to open URL of the AUT

		//using ID
		driver.findElement(By.id("u_0_e")).sendKeys("Vinay");
		
		//using Name
		driver.findElement(By.name("lastname")).sendKeys("Shah");
	
		//CAUTION:  Usually class name is not unique, so need to use it additional locator tech
		//using classname.  
		driver.findElement(By.className("inputtext")).sendKeys("vinay@hotmail.com");
		
		//E.g. Need to type in password field.  But, tHis will type in Email or Phone field
		driver.findElement(By.className("inputtext")).clear();
		driver.findElement(By.className("inputtext")).sendKeys("password1234");
				
		
		//LinkText
		driver.findElement(By.linkText("Forgot account?")).click();		
		Thread.sleep(2000);		
		driver.navigate().back();
		
		//PartialLinkText
		driver.findElement(By.partialLinkText("account")).click();		
		Thread.sleep(2000);		
		driver.navigate().back();
		
		//Using CSS
		driver.findElement(By.cssSelector("#u_0_j")).sendKeys("1234567466");

		//Tag name
		List<WebElement> listTagA = driver.findElements(By.tagName("a"));

		System.out.println("Num of a tag on page ares:  " + listTagA.size());
		
		Thread.sleep(5000);		
		driver.quit();
		System.out.println("End of program");
	}

}
