package appium_project2;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	// Driver Declaration
	AndroidDriver driver;
	WebDriverWait wait;

	// Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page in Chrome
		driver.get("https://training-support.net/webelements");
		
		
		
		
	}
	@Test 
	public void list()
	{
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]"));
		driver.findElement(AppiumBy.id("todo-input")).sendKeys("Buy Dogs");
		driver.findElement(AppiumBy.id("todo-add")).click();
		
	}

}
