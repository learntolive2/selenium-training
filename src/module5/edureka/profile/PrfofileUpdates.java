package module5.edureka.profile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Author:  Vinay Shah
*
* Module 5 - Case Study
* 
 The candidate who has registered for edureka portal wants 
 to update all the professional and personal details available in the portal. 
 Write a selenium script to do the same and explore the edureka portal.
 Steps:
 1. Login to the edureka
 2. Navigate to My Profile
 3. Update professional and personal details
 4. Explore the blogs and Navigate to Main page
 5. Logout of the portal
 * 
 */


public class PrfofileUpdates {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// step1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.edureka.co");
		
		//Login to Edureka
		driver.findElement(By.linkText("Log In")).click();
		
		//Set the credential - After verifying my own -- resetting usename/password for fake identitiy
		String email = "vshah@parasoft.com";
		String passwd = "parasoftqa%test";
		
		WebElement inputEmail = driver.findElement(By.id("si_popup_email"));
		WebElement inputPasswd = driver.findElement(By.id("si_popup_passwd"));
		
		inputEmail.clear();
		inputEmail.sendKeys(email);
		
		inputPasswd.clear();
		inputPasswd.sendKeys(passwd);
		
		driver.findElement(By.xpath("//button[text() = 'Login']")).click();
		
		WebElement userDropdown = driver.findElement(By.xpath("//li[@class='dropdown user_drop']"));
		userDropdown.click();
		
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("My Profile")))).click();
		
		//Open my profile setting
		driver.findElement(By.id("professional_details")).click();
		
		//Update personal details
		driver.findElement(By.xpath("//a[@aria-controls='personalDetails']")).click();
		driver.findElement(By.name("currentrole")).clear();
		driver.findElement(By.name("currentrole")).sendKeys("Selenium trainer");

				
		
		
		//TODO Start from here...
		//Click Continue
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text() = 'CONTINUE']")))).click();
		
		//Click skip
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text() = 'Skip']")))).click();
		
		//Click Next
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text() = 'NEXT']")))).click();
		
		//Click Next
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text() = 'NEXT']")))).click();
		
		//Click SAVE
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text() = 'SAVE']")))).click();
		
		Thread.sleep(5000);

		
		//Log out
		userDropdown.click();
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Log Out")))).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
