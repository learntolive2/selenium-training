package module2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumCommands {

	public BasicSeleniumCommands() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training\\Installation_Stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Get commands
		driver.get("https://www.edureka.co");// to open URL of the AUT

		System.out.println("Title = " + driver.getTitle()); 		//to fetch the title of the page and use it either for validation
		System.out.println("Title = " + driver.getCurrentUrl());	// to fetch the current URL of the AUT
		
		driver.quit();

	}

}
