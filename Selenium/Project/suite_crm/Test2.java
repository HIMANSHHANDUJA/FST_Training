package suite_crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public void test2()
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/crm/");
		WebElement imgsrc=driver.findElement(By.xpath("//img[@alt='suiteCRM']"));
		System.out.println(imgsrc.getAttribute("src"));
	}
}
