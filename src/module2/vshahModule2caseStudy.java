package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Author:  Vinay Shah
 *
 * Module 2 - Case Study
 * 
 * Write aSelenium automation code to perform these 
	steps:
	1.Launch Chrome browser using Selenium WebDriver
	2.Navigate to “https://www.edureka.co/”
	3.Maximise the Browser Window
	4.Inspect the search box with text “Search for a Course” for various attributes usingfirebug 
	5.Get attributes id,name,xpath,class name,css values
	6.Inspect the “Log In” link to get the link text and partial link text
	7.Write a Java code using Selenium WebDriver to make sure that all the element attributes are found on the webpage
	8.Usethe below Selenium WebDriver methods to do that:
	•find_element_by_id
	•find_element_by_name
	•find_element_by_class_name
	•find_element_by_xpath
	•find_element_by_css_selector
	•find_element_by_tag_name
	•find_element_by_link_text,
	•find_element_by_partial_link_text
	9.The  same  code  should  work  with  different  browsers  as  well  (Chrome  and Firefox)
	Note:Make sure that you are logged outof Edureka’s website while performing this practical
 * 
 * Question for instructor:
 * - How to iterate through List of web elements to find specific one? e.g. tagName = input.  But want to find search input box
 * - Is there a way to search using className, where element belogs to multiple classes.
 *   e.g  <div id=foo class=search_inp collapse giTrackElementHeader> 
 */

public class vshahModule2caseStudy {

	static String CHROME_DRIVER = "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe";
	static String FIREFOX_DRIVER = "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\geckodriver.exe";
	
	static String AUT = "http://www.edureka.co";

	
	public static void main(String[] args) throws InterruptedException {		
		//To run using Chrome browser
		System.setProperty("webdriver.chrome.browser", CHROME_DRIVER);	
		WebDriver driver = new ChromeDriver();
		
		//To run using Firefox browser
		//System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER);
		//WebDriver driver = new FirefoxDriver();
		
		//Navigate to AUT
		driver.get(AUT);
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Using id
		searchCourse(driver, "search-inp", "id", "xpath - Selenium Course" );

		//Using Name
		searchCourse(driver, "user_v1[query]", "name", "Name - Java Course" );
		
		//Using Class name = search_inp collapse giTrackElementHeader
		searchCourse(driver, "search_inp", "className", "Class name - Big Data course");
		
		//Using XPath
		searchCourse(driver, "//input[@id='search-inp']", "xpath", "xpath - Python certification");

		//Using CSS selector
		//CSS using class name == .search_inp.collapse.giTrackElementHeader
		searchCourse(driver, ".search_inp.collapse.giTrackElementHeader", "css", "CSS selector using class name = DevOps certification");
		
		//CSS using id
		searchCourse(driver, "#search-inp", "css", "CSS selector using id - DevOps certification");
		
		//Using tag name = input
		//There are many input tags, so we need to find input for search box 
		//TODO - Ask instructor for help
		List<WebElement> tagInput = driver.findElements(By.tagName("input"));
		System.out.println("Number of INPUT tag found = " + tagInput.size());
		System.out.println(" *** HELP **** Instructor please advise here - how to find specific INPUT tag?");
		
		//Using Link and Partial link for Log In
		clickLink(driver, "Log In", "linkText");
		
		//Using partial link text
		clickLink(driver, "Log", "partialLinkText");
		
		//driver.close();
		driver.quit();// this will close all the window opened during this instance

	}

	static void searchCourse(WebDriver driver, String locate, String locatorUsing, String searchText) throws InterruptedException
	{
		WebElement elm = null;
		System.out.println("locate = " + locate);
		System.out.println("Using  = " + locatorUsing);
		System.out.println("Search string = " + searchText);
		
	        switch(locatorUsing) 
	        { 
	            case "id": 
	                System.out.println("Finding element using id locator" );
	                elm = driver.findElement(By.id(locate));
	                break; 
	            case "name": 
	                System.out.println("Finding element using Name locator" );
	                elm = driver.findElement(By.name(locate));
	                break; 
	            case "className": 
	                System.out.println("Finding element using Class name locator" );
	                elm = driver.findElement(By.className(locate));
	                break; 
	            case "xpath": 
	                System.out.println("Finding element using XPath locator" );
	                elm = driver.findElement(By.xpath(locate));
	                break; 
	            case "css": 
	                System.out.println("Finding element using CSS locator" );
	                elm = (WebElement) driver.findElement(By.cssSelector(locate));
	                break;                 
	            default: 
	                System.out.println("Unsupported type for lcoator selection.  Please try again"); 
	        } 		
	        
	        if (elm != null && elm.isDisplayed()) 
	        {
		        elm.clear();
		        elm.sendKeys(searchText);	       
		        elm.sendKeys(Keys.RETURN);
		        //driver.findElement(By.id("search-button-top")).click(); //click search button
		        Thread.sleep(3000);
				driver.navigate().back();
				//Thread.sleep(2000);
	        }
	}

	static void clickLink(WebDriver driver, String locate, String locatorUsing) throws InterruptedException
	{
		WebElement elm = null;
		System.out.println("locate = " + locate);
		System.out.println("Using  = " + locatorUsing);
		
	        switch(locatorUsing) 
	        { 
	            case "linkText": 
	                System.out.println("Finding element using LinkText locator" );
	                elm = driver.findElement(By.linkText(locate));
	                break; 
	            case "partialLinkText": 
	                System.out.println("Finding element using PartialLinkText locator" );
	                elm = driver.findElement(By.partialLinkText(locate));
	                break; 

	                default:
	                	System.out.println("Finding element using PartialLinkText locator" );
	                
	        }

	        if (elm != null && elm.isDisplayed())
	        {
	        	elm.click();
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//div[@class='modal-dialog']//button[@class='close']")).click();
	        	Thread.sleep(2000); 	
	        }
	        
	}

}
