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

public class Activity3
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
	public void testProgress()
	{
		 driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]")).click();
		 driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]")).click();
		 
		 
		 WebElement thirdTask =
			       (WebElement) driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"low\"]"));
			   new TouchAction(driver)
			     .longPress(LongPressOptions.longPressOptions()
			     .withElement(ElementOption.element(thirdTask)))
			     .release()
			     .perform();
			   driver.findElement(AppiumBy.id("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();
			   WebElement slider =driver.findElement(AppiumBy.id("//android.widget.SeekBar[@resource-id=\"com.app.todolist:id/sb_new_task_progress\"]")); 
			   
			   
					   int startX = slider.getLocation().getX();
					   int endX = startX + (slider.getSize().getWidth() / 2);
					   int y = slider.getLocation().getY();
					   new TouchAction(driver)
					   .press(PointOption.point(startX, y))
					   .moveTo(PointOption.point(endX, y))
					   .release()
					   .perform();
					   driver.findElement(By.id("com.app.todolist:id/bt_new_task_ok")).click();
					   
					   driver.findElement(By.id("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
					   driver.findElement(By.id("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]")).click();
					   Assert.assertTrue(
							     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\\\"com.app.todolist:id/tv_exlv_task_name\\\" and @text=\\\"High\\\"]")).isDisplayed());
					   Assert.assertTrue(
							     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Medium\"]")).isDisplayed());
					 
					 
	}
	
	
}
