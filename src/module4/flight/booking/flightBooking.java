package module4.flight.booking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Author:  Vinay Shah
*
* Module 4 - Case Study
* 
 A person wants to check for the one-wayflights from Bengaluru to Lucknow
 for 5 passengers(3 Adults and 2 children) on Indigo portal for the current date.
 Automate the same using (https://www.goindigo.in/?linkNav=home_header) portal.
 The steps are as below.
 Steps:
 1. Launch the browser with “https://www.goindigo.in/?linkNav=home_header”
 2. Select “One way” in the option
 3. Fill all the details specified above
 4. Click on search button
 5. Wait for the page to load and list all the flights available
 * 
 */


public class flightBooking {

	public static void main(String[] args) throws InterruptedException {
	
		// step1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.goindigo.in/?linkNav=home_header");

		// Step 2. Select “One way” in the option
		driver.findElement(By.xpath("//label[@for = 'oneWayTrip']")).click();
		
		//Step 3. Fill all the details specified above
		//Click in From field
		WebElement departSearch = driver.findElement(By.xpath("//*[@id='bookFlightTab']/form/div[3]/div[1]/div[1]/div"));
		myWait.until(ExpectedConditions.visibilityOf(departSearch));
		
		
		//driver.findElement(By.xpath("//*[@id='bookFlightTab']/form/div[3]/div[1]/div[1]/div")).click();
		
		Thread.sleep(3000);
		//Type departing city
		//myWait.until(arg0)
		driver.findElement(By.xpath("//*[@id='orSrcModal']//input")).sendKeys("Bengaluru");
		
		//Select city
		driver.findElement(By.xpath("//*[@id='orSrcModal']//div[@data-iata='BLR' and contains(@class, 'pop-dest-stn')]"));
		
		//Search for destination city - Lucknow
		driver.findElement(By.xpath("//*[@id='orDestModal']//input")).sendKeys("Lucknow");
		
		//Select destination airport from auto-complete
		//*[@id='orDestModal']//div[@data-iata='LKO']
		driver.findElement(By.xpath("//*[@id='orDestModal']//div[@data-iata='LKO']"));
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
