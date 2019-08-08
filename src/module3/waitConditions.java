package module3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitConditions {

	//static String CHROME_DRIVER = "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe";
	//static String FIREFOX_DRIVER = "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\geckodriver.exe";
	
	static String AUT = "https://seleniumautomationpractice.blogspot.com/2017/10/waitcommands.html";

	
	public static void main(String[] args) throws InterruptedException {		
		//To run using Chrome browser
		System.setProperty("webdriver.chrome.browser", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Initiate WebDriver() .. now waiting for 5s");
		Thread.sleep(5000);
		
		try
		{
			
		
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		
		//When page timeout happens following error occurs:
		String pageLoadTimoutError = "Exception in thread \"main\" org.openqa.selenium.TimeoutException: timeout\r\n" + 
				"  (Session info: chrome=76.0.3809.100)\r\n" + 
				"  (Driver info: chromedriver=2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e),platform=Windows NT 10.0.18362 x86_64) (WARNING: The server did not provide any stacktrace information)\r\n" + 
				"Command duration or timeout: 1.03 seconds\r\n" + 
				"Build info: version: 'unknown', revision: 'unknown', time: 'unknown'\r\n" + 
				"System info: host: 'WINDOWS-T2J5451', ip: '192.168.1.68', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_92'\r\n" + 
				"Driver info: org.openqa.selenium.chrome.ChromeDriver\r\n" + 
				"Capabilities [{mobileEmulationEnabled=false, hasTouchScreen=false, platform=XP, acceptSslCerts=false, goog:chromeOptions={debuggerAddress=localhost:50627}, acceptInsecureCerts=false, webStorageEnabled=true, browserName=chrome, takesScreenshot=true, javascriptEnabled=true, setWindowRect=true, unexpectedAlertBehaviour=, applicationCacheEnabled=false, rotatable=false, networkConnectionEnabled=false, chrome={chromedriverVersion=2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e), userDataDir=C:\\Users\\Vinay\\AppData\\Local\\Temp\\scoped_dir10888_19079}, takesHeapSnapshot=true, pageLoadStrategy=normal, databaseEnabled=false, handlesAlerts=true, version=76.0.3809.100, browserConnectionEnabled=false, nativeEvents=true, locationContextEnabled=true, cssSelectorsEnabled=true}]\r\n" + 
				"Session ID: 68867ad8b276f9b57c99a059deba5b94\r\n" + 
				"	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n" + 
				"	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n" + 
				"	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n" + 
				"	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n" + 
				"	at org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n" + 
				"	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n" + 
				"	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\r\n" + 
				"	at org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:364)\r\n" + 
				"	at module3.waitConditions.main(waitConditions.java:37)\r\n" + 
				"";

		 
		
			//Navigate to AUT
			driver.get(AUT);
		}
		catch (Exception e) {
			System.out.println("PageLoadTimeOut exception caught -- continue..." + e);
		}
		
		//PageLoad timeout
		//System.out.println("\n\n");
		//System.out.println("pageLoadTimeout -- looks like == " + pageLoadTimoutError);
		
		
/*
 * 
 * Exception in thread "main" org.openqa.selenium.TimeoutException: timeout
  (Session info: chrome=76.0.3809.100)
  (Driver info: chromedriver=2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e),platform=Windows NT 10.0.18362 x86_64) (WARNING: The server did not provide any stacktrace information)
Command duration or timeout: 1.03 seconds
Build info: version: 'unknown', revision: 'unknown', time: 'unknown'
System info: host: 'WINDOWS-T2J5451', ip: '192.168.1.68', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_92'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities [{mobileEmulationEnabled=false, hasTouchScreen=false, platform=XP, acceptSslCerts=false, goog:chromeOptions={debuggerAddress=localhost:50627}, acceptInsecureCerts=false, webStorageEnabled=true, browserName=chrome, takesScreenshot=true, javascriptEnabled=true, setWindowRect=true, unexpectedAlertBehaviour=, applicationCacheEnabled=false, rotatable=false, networkConnectionEnabled=false, chrome={chromedriverVersion=2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e), userDataDir=C:\Users\Vinay\AppData\Local\Temp\scoped_dir10888_19079}, takesHeapSnapshot=true, pageLoadStrategy=normal, databaseEnabled=false, handlesAlerts=true, version=76.0.3809.100, browserConnectionEnabled=false, nativeEvents=true, locationContextEnabled=true, cssSelectorsEnabled=true}]
Session ID: 68867ad8b276f9b57c99a059deba5b94
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)
	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)
	at org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:364)
	at module3.waitConditions.main(waitConditions.java:37)
 *  		
 */
	
		//Implict wait -- applies to all driver action as part of this driver execution.
		//Example - if we set the implicit wait for 10s, then it applies to all the driver.<actions> for web elements.
		//
		//Usecase - if try to perform click on webEm1, webElm2, webElm3 == this max. wait condition applies for each one of them before timingout
		//webElm1 == wait upto 10 sec.  If webElm1 is avail to perform action in less than specified timeout, test will continue as soon as action performed.  Doesn't wait for max timeout 
		
		try {
			System.out.println("Title = " + driver.getTitle());

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("Example of impicit wait \n");
			System.out.println("LinkText5.text() should timeout == " + driver.findElement(By.linkText("LinkText-5")).getText());
		
			System.out.println("LinkText0.text() SHOULD NOT timeout == " + driver.findElement(By.linkText("LinkText-0")).getText());
		
		} catch (Exception e) {
			System.out.println("\n\nImplictlyWait timeout exception -- " + e);
		}
		

		//Explict wait command
		
		try 
		{
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(AUT);
			
			//WebElement elm = driver.findElement(By.partialLinkText("Link-Text5"));
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText("Link-Text5")))).click();
			
			
			//driver.findElement(By.id("search-inp")).sendKeys("Java course");
	
		} catch (Exception e) {
			System.out.println("Explict wait Exception caught -- continue..." + e);
		}
		
		System.out.println("End of program... ");
		driver.quit();
		}

}