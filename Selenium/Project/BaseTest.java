package suite_crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/crm/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			{
			driver.quit();
			}
	}
	public static void main(String[] args)
	{
		BaseTest base=new BaseTest();
		base.setUp();
	}

}
