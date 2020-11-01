/*
 * Author: Shailaja Charbhai
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void verifyAmazonTitle() throws InterruptedException  {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D://Selenium_LatestLib//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://Amazon.com");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getTitle().contains("AAA"));
		Thread.sleep(1000);
				
		driver.quit();
		}
	

}
	

