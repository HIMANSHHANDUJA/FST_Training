package appium_project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Activity2
{
	AndroidDriver driver;
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException { 
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("android");
	options.setAutomationName("UiAutomator2");
	options.setApp("src/test/resources/ts-todo-list-v1.apk");
	
	URL serverURL=new URI("http://192.168.1.7:4723").toURL();
	
	driver=new AndroidDriver(serverURL,options);
	}
	
	
	@Test
	public void editTeaskDeadline()
	{
		   WebElement firstTask =
		       (WebElement) driver.findElements(AppiumBy.id("com.app.todolist:id/fab_new_task"));
		   new TouchAction(driver)
		     .longPress(LongPressOptions.longPressOptions()
		     .withElement(ElementOption.element(firstTask)))
		     .release()
		     .perform();
		   driver.findElement(AppiumBy.id("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();
		   driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click(); 
		   driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"10 January 2026\"]")).click();
		   driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
		   driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();

		   
		   Assert.assertTrue(
		     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\" and @text=\"Deadline: 10.01.2026\"]")).isDisplayed());
	}
	
	
	
}
