package suite_crm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Activity1Test extends BaseTest{
	@Test
	public void test1 ()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"SuiteCRM");
	}
	
	@Test
	public void test4()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void test5()
	{
		WebElement navColor=driver.findElement(By.xpath("//nav[@role='navigation']"));
		String bgColor=navColor.getCssValue("background-color");
		System.out.println(bgColor);
		
	}
	@Test
	public void test6()
	{
		WebElement activityTab=driver.findElement(By.xpath("//a[@id='grouptab_3']"));
		Assert.assertTrue(activityTab.isDisplayed()) ;
		//    clickable_element = wait.until(EC.element_to_be_clickable((By.ID, "your_element_id")));
		activityTab.isEnabled();
	}
	@Test
	public void test7()
	{
		Actions actions=new Actions(driver);
		WebElement salesTab=driver.findElement(By.xpath("//a[text()='Sales']"));
		actions.moveToElement(salesTab).perform();
		//explicitWait
		List<WebElement> salesItems=(List<WebElement>) salesTab;
		for(WebElement item: salesItems)
		{
			if(item.getText().equalsIgnoreCase("Leads"))
			{
				item.click();
				break;
			}
		}
		//wait
		WebElement addtnlDetail=driver.findElement(By.xpath("//tr[.//b[text()='Darlene C Witmer']]//td[last()]//span[@title='Additional Details']"));
		addtnlDetail.click();
		WebElement phoneNo=driver.findElement(By.xpath("//span[@class='phone']"));
		System.out.println(phoneNo);
	}
	@Test
	public void test8()
	{
		Actions actions=new Actions(driver);
		WebElement salesTab=driver.findElement(By.xpath("//a[text()='Sales']"));
		actions.moveToElement(salesTab).perform();
		//explicitWait
		List<WebElement> salesItems=(List<WebElement>) salesTab;
		for(WebElement item: salesItems)
		{
			if(item.getText().equalsIgnoreCase("Accounts"))
			{
				item.click();
				break;
			}
		}
		List <WebElement> oddNames=driver.findElements(By.xpath("//table/tbody/tr[position() mod 2=1]/td[3]"));
		for(WebElement name:oddNames)
		{
			System.out.println(name.getText());
		}
		
	}
	@Test
	public void test9()
	{
		Actions actions=new Actions(driver);
		WebElement salesTab=driver.findElement(By.xpath("//a[text()='Sales']"));
		actions.moveToElement(salesTab).perform();
		//explicitWait
		List<WebElement> salesItems=(List<WebElement>) salesTab;
		for(WebElement item: salesItems)
		{
			if(item.getText().equalsIgnoreCase("Accounts"))
			{
				item.click();
				break;
			}
		}
		List<WebElement> dataRows=driver.findElements(By.xpath("//table//tr[td]"));
		int count=0;
		for(WebElement row:dataRows)
		{
			if(count==10)
			{
				break;
			}
			String name=
					row.findElement(By.xpath("./td[3]")).getText();
			String user=
					row.findElement(By.xpath("./td[8]")).getText();
			System.out.println("Name: "+ name + " | User: "+ user);
			count++;
			
			
		 }
		
	}
}
