package searchProduct;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchOnFlipkart {
	WebDriver driver;

	@Test(groups = "Edge")
	public void firefoxTest() throws InterruptedException {
		System.out.println("Testing using Microsoft Edge......");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\TARUN\\OneDrive\\Desktop\\JAR FILES\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println("Flipkart Home Page Loaded");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed the Signup activity");
		// search iPhone 13
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iPhone 13");
		System.out.println("Inserted the keyword in Search Box..");
		driver.findElement(By.cssSelector(".L0Z3Pu > svg")).click();
		System.out.println("Searched the Product");
		// Image loading
		String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		driver.get(url);
		// identify image
		WebElement i = driver.findElement(By.xpath(
				"//img[contains(@src,'https://rukminim1.flixcart.com/image/312/312/ktketu80/mobile/s/l/c/iphone-13-mlpf3hn-a-apple-original-imag6vzz5qvejz8z.jpeg?q=70')]"));
		// Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		// verify if status is true
		if (p) {
			System.out.println("Image Loaded");
		} else {
			System.out.println("Image not Loaded");
		}
		// Load Time
		System.out.println("The title of the page is :" + driver.getTitle());
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Loading Time : " + loadtime);
		// Scrolling
		try {
			long lastHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (Long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
			// Page scroll to down
			// object of Actions class to scroll up and down
//		      Actions at = new Actions(driver);
//		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
			if (lastHeight > 0)
				System.out.println("Scrolled & Height of Page : " + lastHeight);
			else
				System.out.println("Not Scrolled");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(groups = "Chrome")
	public void chromeTest() throws InterruptedException {
		System.out.println("Performing testing through Chrome Browser..");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TARUN\\OneDrive\\Desktop\\JAR FILES\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println("Flipkart Page Loaded");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed the signup activity..");
		// search iPhone 13
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iPhone 13");
		System.out.println("Inserted the keyword in Search Box..");
		driver.findElement(By.cssSelector(".L0Z3Pu > svg")).click();
		System.out.println("Search Working Successfully");
		// Image loading
		String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		driver.get(url);
		// identify image
		WebElement i = driver.findElement(By.xpath(
				"//img[contains(@src,'https://rukminim1.flixcart.com/image/312/312/ktketu80/mobile/s/l/c/iphone-13-mlpf3hn-a-apple-original-imag6vzz5qvejz8z.jpeg?q=70')]"));
		// Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		// verify if status is true
		if (p) {
			System.out.println("Image Loaded");
		} else {
			System.out.println("Image not Loaded");
		}
		// Load Time
		System.out.println("The title of the page is :" + driver.getTitle());
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Loading Time : " + loadtime);
		// Scrolling
		try {
			long lastHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (Long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
			// Page scroll to down
			// object of Actions class to scroll up and down
//		      Actions at = new Actions(driver);
//		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
			if (lastHeight > 0)
				System.out.println("Scrolled & Height of Page : " + lastHeight);
			else
				System.out.println("Not Scrolled");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Testing Started");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Testing Done!");
	}

}
