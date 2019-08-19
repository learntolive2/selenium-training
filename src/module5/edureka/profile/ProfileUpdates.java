package module5.edureka.profile;

import java.util.Set;
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

public class ProfileUpdates {

	public static void main(String[] args) throws InterruptedException {
		
		// Set the valid credential - this was verified for Vinay
		String EMAIL_ID = "";
		String PASSWORD = "";

		if (EMAIL_ID.isEmpty() || PASSWORD.isEmpty())
		{			
			System.out.println("REQUIRED - To use this program set the 'EMAIL_ID' and 'PASSWORD' to login to Edureka LMS portal");
			System.out.println("Exiting the program... ");
			System.exit(0);
		}
		// step1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.edureka.co");

		// Login to Edureka
		driver.findElement(By.linkText("Log In")).click();

		WebElement inputEmail = driver.findElement(By.id("si_popup_email"));
		WebElement inputPasswd = driver.findElement(By.id("si_popup_passwd"));

		inputEmail.clear();
		inputEmail.sendKeys(EMAIL_ID);

		inputPasswd.clear();
		inputPasswd.sendKeys(PASSWORD);

		driver.findElement(By.xpath("//button[text() = 'Login']")).click();

		// 2. Navigate to My Profile
		WebElement userDropdown = driver.findElement(By.xpath("//li[@class='dropdown user_drop']"));
		userDropdown.click();

		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("My Profile")))).click();

		// Click pencil icon to - edit Professional details
		driver.findElement(By.id("professional_details")).click();

		// 3. Update professional and personal details
		// Click "Personal Details" from left menu panel
		myWait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[@aria-controls='personalDetails']")))).click();
		Thread.sleep(3000);
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("currentrole")))).clear();
		driver.findElement(By.name("currentrole")).sendKeys("Selenium trainer");

		// Update professional details
		// Click Continue
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
				By.xpath("//form[contains(@class, 'personal-details-form')]//button[text() = 'Continue']")))).click();
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
				By.xpath("//form[contains(@class, 'personal-details-form')]//button[text() = 'Continue']")))).click();
		Thread.sleep(3000);

		// Click skip - career interest
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
				By.xpath("//div[contains(@class, 'career-service-interested')]/a[normalize-space(.) = 'Skip']"))))
				.click();

		// Click Next - professional-interest
		myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='userSkill']"))))
				.clear();
		driver.findElement(By.xpath("//input[@name='userSkill']")).sendKeys("Test Automation");
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
				By.xpath("//form[contains(@class, 'professional-details-form')]//button[text() = 'Next']")))).click();

		// Click Next - Career interest
		myWait.until(ExpectedConditions.elementToBeClickable(driver
				.findElement(By.xpath("//form[contains(@class, 'career-interest-form')]//button[text() = 'Next']"))))
				.click();

		// Click SAVE
		myWait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//div[contains(@class,'finish-button-div')]//button[text() = 'Save']"))))
				.click();

		Thread.sleep(2000);

		/*
		 * //4. Navigate to blog //Nav to home page, then goto Community blog & explore
		 * driver.get("https://www.edureka.co");
		 * 
		 * myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
		 * xpath("//div[contains(@class, 'menu-dropdown')]//a[@data-button-name='Community']"
		 * )))).click(); driver.findElement(By.
		 * xpath("//li[@data-gaact='Community - Blog']/a[normalize-space() = 'Blog']")).
		 * click();
		 * 
		 * Set<String> win = driver.getWindowHandles(); System.out.print
		 * ("Total number of open windows = " + win.size());
		 * 
		 * 
		 * //the blog page opens in new window //There is pop-up message to dismiss it
		 * if
		 * 
		 * (driver.findElement(By.id("wzrk-cancel")).isDisplayed()) {
		 * System.out.println("Message pop present -- next, dismiss it");
		 * driver.findElement(By.id("wzrk-cancel")).click(); }
		 * 
		 * driver.findElement(By.partialLinkText("Cyber Security")).click();
		 * 
		 * 
		 * 
		 * //explorer something here..
		 * 
		 * if (2 == win.size()) { driver.navigate().refresh(); //to get rid of pop up
		 * //driver.findElement(By.id("wzrk-cancel")).click(); driver.close(); //close
		 * the active window }
		 */
		// Make sure we are on the main page
		//driver.get("https://learning.edureka.co/mycourses");

		
		// Log out
		userDropdown = driver.findElement(By.xpath("//li[@class='dropdown user_drop']"));
		myWait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
		myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Log Out")))).click();

		Thread.sleep(5000);
		driver.quit();
	}

}
