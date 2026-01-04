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

public class Activity1
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
	public void createList()
	{
		
		driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).sendKeys("Complete Activity 1");
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"));
		Assert.assertEquals("Complete Activity 1", driver.findElement(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));
		
		driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).sendKeys("Complete Activity 1");
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"));
		Assert.assertEquals("Complete Activity 2", driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Medium\"]")));

		driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).sendKeys("Complete Activity 1");
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"));
		Assert.assertEquals("Complete Activity 3", driver.findElement(AppiumBy.id("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Low\"]")));


	}
	
	
	
}
