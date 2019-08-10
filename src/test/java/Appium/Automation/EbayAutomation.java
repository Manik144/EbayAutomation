package Appium.Automation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Ebay_Pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.PressesKey;

public class EbayAutomation {
	
	public static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		ebayAutomation();
	}

	
	public static void ebayAutomation() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("deviceName", "Moto G");
		cap.setCapability("udid", "ZY322C3QH5");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appPackage", "com.ebay.mobile");
		cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		cap.setCapability("automationName", "uiautomator2");
		
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		System.out.println("Application Started....");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.ebay.mobile:id/auxiliary_toolbar")).click();
		driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).sendKeys("Watches");
		/*Robot robot = new Robot();
		
        robot.keyPress(KeyEvent.VK_ENTER);*/
        Thread.sleep(2000);
		driver.findElement(By.id("com.ebay.mobile:id/text")).click();
		
		Thread.sleep(5000);
		//String win1 = driver.getWindowHandle();
		driver.findElement(By.id("com.ebay.mobile:id/text_slot_1")).click();
		driver.findElement(By.id("com.ebay.mobile:id/button_sort")).click();
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//*[@text = 'Highest Price + Shipping']")).click();
		/*Set<String> windowHandles = driver.getWindowHandles();
		driver.switchTo().frame(1);*/
		//driver.switchTo().frame("com.ebay.mobile:id/button_filter_subelement");
		/*System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String win : windowHandles) {
			if(!(win.equalsIgnoreCase(win1))) {
				driver.switchTo().window(win);
				driver.findElement(By.id("com.ebay.mobile:id/button_filter_subelement")).click();
				driver.switchTo().window(win1);
			}
		}*/
		
		Thread.sleep(2000);
		driver.findElement(By.id("com.ebay.mobile:id/textview_item_title")).click();
		Thread.sleep(2000);
		
		List<MobileElement> wb1 = driver.findElements(By.id("com.ebay.mobile:id/textview_item_title"));
		List<MobileElement> wb2 = driver.findElements(By.id("com.ebay.mobile:id/textview_item_price"));
		System.out.println("No Of Elements : " + wb1.size());
				
		for(int i =0; i < wb1.size()-1; i++) {
			String name = wb1.get(i).getText();
			String price = wb2.get(i).getText();
			System.out.println("Name is : " + name);
			System.out.println("Price is : " + price);
		}
		driver.findElement(By.id("com.ebay.mobile:id/textview_item_title")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.ebay.mobile:id/action_view_icon")).click();
		
		String title = driver.findElement(By.id("com.ebay.mobile:id/title")).getText();
		
		Assert.assertEquals(title, "Sign in");
		
		System.out.println("Test Completed");
		/*((AppiumDriver<MobileElement>) driver.switchTo()).context("NATIVE_APP");
		driver.getTitle();*/
		 driver.quit();
		
		
	}
}
