package module3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VinayModule3CaseStudy {

	public static void main(String[] args) throws InterruptedException {
		
		// step1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Step 2. Set the Selenium page loadtimeout after launching the browser. This timeout will be applicable to any page load
		// pageLoadTimeout doesn't work with Selenium version 3.4
		// Suggested work-around to use v3.5, but not what other issue it may bring
		// Ref: https://stackoverflow.com/questions/45591282/pageloadtimeout-in-selenium-not-working
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		//Step 3. Navigate to “https://www.edureka.co/”
		driver.get("https://www.edureka.co");

		//Step 4. Maximizethe Browser Window
		driver.manage().window().maximize();
		
		//Selenium 3.5 --> introduced another issue, unable to interact with web element.
		//	Exception in thread "main" org.openqa.selenium.WebDriverException: Unrecognized platform: windows nt
		//
		// Ref: https://github.com/SeleniumHQ/selenium/issues/4781#issuecomment-333452945
		
		System.out.println(driver.getTitle());
		
		//Step 5. Set implicit wait for all the activities on the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Step 6. Set selenium script timeout and execute any asynchronous script
		//(Ex: window.setTimeout(arguments[arguments. Length-1], 500);)to validate the  script timeout
		
				
		//Step 7. Search for “Selenium” course in the search box and press “Enter”
		WebElement searchBar = driver.findElement(By.id("search-inp"));
		searchBar.clear();
		searchBar.sendKeys("Selenium");
		searchBar.sendKeys(Keys.RETURN);
				
		//Step 8. Add explicit wait for page to navigate to selenium course and click on the course
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions
				.elementToBeClickable
				(driver.findElement(By.xpath("//h3[contains(text(), 'Selenium Certification')]")))).click();

		//Step 9. Wait for the whole selenium course page to be loaded and get the title of the page
		String actualTitle = driver.getTitle();
		System.out.println("After clicking Selenium course page - navigated window title:  " + actualTitle);
	
		//Step 10. Validate the page title to be “Selenium 3.0 WebDriver Online Training”
		String expectedTitle = "Selenium 3.0 WebDriver Online Training";
		if (actualTitle.equals(expectedTitle))
			System.out.println("Navigated course windows page title matches with our extpect result");
		else
		{
			System.out.println("Navigated course windows page title doesn't matches with our extpect result");
			System.out.println("Expected title:  " + expectedTitle);
			System.out.println("Actual title:  " + actualTitle);	
		}
		
		//Step 11. Navigate back to the previous page
		//driver.navigate().back();	//This will take us back to Search result page, and there isn't any "All Courses' option menu/link.
									//Hence not performing back, but showing you how navigate to previous page
		
		
		//Step 12. Wait for whole page to be loaded and now select “All courses” from the menu option
		driver.findElement(By.linkText("All Courses")).click();
		
		String expectedURL = "https://www.edureka.co/all-courses";
		String actualURL = driver.getCurrentUrl();
		
		if (actualURL.equalsIgnoreCase(expectedURL))
			System.out.println("Navigated 'All course' link - URL matches with our extpected URL");
		else
		{
			System.out.println("Navigated 'All course' link - URL doesn't matches with our extpected URL");
			System.out.println("Expected title:  " + expectedURL);
			System.out.println("Actual URL:  " + actualURL);	
		}
	
		//Step 13. Add a fluent wait script to wait for whole page to be loaded under “All course”
		FluentWait fWait = new FluentWait(driver);
		fWait.withTimeout(45, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS);
		
		
		Thread.sleep(9000);
		driver.quit();
	}

}
