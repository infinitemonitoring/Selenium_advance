package com.starquick.test;

import java.util.List;
import  org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.starquick.manager.DriverManager;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
	
	@Test
	public void test1() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Faraz Dasurkar ", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assertions.assertThat(title).containsIgnoringCase("google search").hasSizeBetween(15, 100); 
		// testng Assertions
//		Assert.assertTrue(Objects.nonNull(title));
//		Assert.assertTrue(title.toLowerCase().contains("google search"));
//		Assert.assertTrue(title.length()>15);
//		Assert.assertTrue(title.length()<100);
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//span//h3"));
		Assertions.assertThat(elements)
		.isNotEmpty().isNotNull()
		.extracting(e->e.getText())
		.contains("Faraz Dasurkar - 3Di Systems");
		
		// TestNG Assertions 
//		System.out.println(elements.size());
//		Assert.assertEquals(elements.size(), 9);
//		boolean isElementprensent = false;
//		for(WebElement element : elements) {
//			if(element.getText().equalsIgnoreCase("Faraz Dasurkar - 3Di Systems")) {
//			isElementprensent = true;
//			break;
//			}
//		}
//		Assert.assertTrue(isElementprensent,"Faraz Dasurkar - 3Di Systems is present");
	}
	


}
