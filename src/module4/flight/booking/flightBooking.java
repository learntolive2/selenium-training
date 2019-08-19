package module4.flight.booking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
 1. Launch the browser with https://www.goindigo.in/?linkNav=home_header
 2. Select One way in the option
 3. Fill all the details specified above
 4. Click on search button
 5. Wait for the page to load and list all the flights available
 * 
 */

// 08-18-2019 -- Fixed the merge conflict

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

		// Step 2. 
		driver.findElement(By.xpath("//label[@for = 'oneWayTrip']")).click();
		
		//Step 3. Fill all the details specified above
		//Click in From field
		WebElement departSearch = driver.findElement(By.xpath("//*[@id='bookFlightTab']/form/div[3]/div[1]/div[1]/div"));
		myWait.until(ExpectedConditions.visibilityOf(departSearch));
		
		//Type departing city
		departSearch.click();
		
		////div[@id='bookFlightTab']//input[@data-parsley-airport-message='Please select a Source'][1]
		//driver.findElement(By.xpath("//div[@id='bookFlightTab']//input[@data-parsley-airport-message='Please select a Source'][1]")).clear();
		//driver.findElement(By.xpath("//*[@id='orSrcModal']//div[@data-iata='BLR' and contains(@class, 'pop-dest-stn')]")).click();	//Selecting from pop-up auto complete result
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//input[@data-parsley-airport-message='Please select a Source'][1]")).sendKeys("BLR", Keys.ENTER);
		
		//After entering the departing city and hit enter, focus automatically goes into destination selection
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//input[@data-parsley-airport-message='Please select a Destination'][1]")).sendKeys("LKO", Keys.ENTER);
	
		Thread.sleep(3000);
		
		//After destination city, date field gets auto focus and opens the dropdown for date pick
		//Since have to select the current date, its safe to click accept default selection and click Done to close the dialog
		//click Done to close date picker dialog

		String strDateCloseBtn = "//div[@id='bookFlightTab']//a[contains(@class, 'dateClose') and text() = 'Done']"; 
		
		//Not working
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath(strDateCloseBtn)));
		
		//Try2 - click in date-picker title (in its modal window) -- Didn't help
		//myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='ui-datepicker-title'][1]")))).click();
		
		//Try3 - Instead of clicking Done, let's try selecting an active date.  Which is always current - Today's date selected
		driver.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]")).click();
		
		//Aug 18, 2019 - some reason this stopped working.  There was an additional pop-up Help element, which cannot be dismiss
		//	Exception in thread "main" org.openqa.selenium.WebDriverException: unknown error: Element is not clickable at point (647, 688)
		//  	(Session info: chrome=75.0.3770.80)
		  
		//driver.findElement(By.xpath("//div[@id='bookFlightTab']//a[contains(@class, 'dateClose') and text() = 'Done']")).click();
		//myWait.until(ExpectedConditions.elementToBeClickable
		//		(driver.findElement(By.xpath("//div[@id='bookFlightTab']//a[contains(@class, 'dateClose') and text() = 'Done']")))).click();
		
		//Click passenger to open dropdown to select count
		//xpath = //div[@id='bookFlightTab']//input[@name='passenger']
		driver.findElement(By.name("passenger")).click();
		
		//
		//To increase # of adult passenger count
		////div[@id='bookFlightTab']//li[@class='adult-pax-list']//button[contains(@class, 'pax-plus')]
		//Default adult count = 1 (cannot lower it).
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//li[@class='adult-pax-list']//button[contains(@class, 'pax-plus')]")).click();  //click once to have 2 adults
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//li[@class='adult-pax-list']//button[contains(@class, 'pax-plus')]")).click();  //click twice to have 3 adults
		
		
		//For child
		////div[@id='bookFlightTab']//li[@class='child-pax-list']//button[contains(@class, 'pax-plus')]
		//Default child count = 0 (cannot lower it).
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//li[@class='child-pax-list']//button[contains(@class, 'pax-plus')]")).click();  //click once to have 1 child
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//li[@class='child-pax-list']//button[contains(@class, 'pax-plus')]")).click();  //click twice to have 2 children
		
		//Aug 18, 2019 - some reason this stopped working.  There was an additional pop-up Help element, which cannot be dismiss
		//Exception in thread "main" org.openqa.selenium.WebDriverException: unknown error: Element is not clickable at point (647, 688)
		//  (Session info: chrome=75.0.3770.80)
		//Click 'Done' button to close the passenger dropdown
		//xpath = //div[@id='bookFlightTab']//button[text()='Done']
		//driver.findElement(By.xpath("//div[@id='bookFlightTab']//button[text()='Done']")).click();
		
		//Work-around - to suppress passenger selection dropdown.  Click somewhere outside the dropdown
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//h4")).click();
		
		
		//Click Search Flight button
		//xpath = //div[@id='bookFlightTab']//span[text()='Search Flight']
		driver.findElement(By.xpath("//div[@id='bookFlightTab']//span[text()='Search Flight']")).click();
		
		
		//TODO From here - 8/13 5pm
		
		//Wait for the search result page to load
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
		fWait.withTimeout(120, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS);
		
		
		//Thread.sleep(60000);
		//driver.quit();
		
	}

}