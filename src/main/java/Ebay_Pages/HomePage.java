package Ebay_Pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage {
	
	AppiumDriver<MobileElement> driver;
	
	public HomePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	@AndroidFindBy(id = "com.ebay.mobile:id/auxiliary_toolbar")
	static AndroidElement searchBox;
	@AndroidFindBy(id = "com.ebay.mobile:id/search_src_text") 
	static AndroidElement searchTextBox;

	
	public static void search(String text) {
		searchBox.click();
		searchTextBox.sendKeys(text);
	}

}
