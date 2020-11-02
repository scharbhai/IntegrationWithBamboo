/*
 * Author: Shailaja Charbhai
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testAmazonTitle() throws InterruptedException  {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D://Selenium_LatestLib//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lntinfotech.com/");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getTitle().contains("lti"));
		Thread.sleep(1000);
		driver.quit();
		}
	

}
	

