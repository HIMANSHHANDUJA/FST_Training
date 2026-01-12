package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net");
		
		System.out.println(driver.getTitle());
	    WebElement abtClickBtn=driver.findElement(By.cssSelector("a.card"));
	    abtClickBtn.click();
	    Thread.sleep(2000);
	    WebElement abouttxt=driver.findElement(By.cssSelector("h2.mt-3"));
	    
	    System.out.println(abouttxt.getText());
	   
	    
	}

}
