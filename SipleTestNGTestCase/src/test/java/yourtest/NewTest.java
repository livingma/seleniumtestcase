package yourtest;

import java.io.File;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.*;

import com.thoughtworks.selenium.*;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class NewTest extends SeleneseTestBase {
	@Test
	public void f() {
		Assert.assertEquals(true, true);
	}




	@BeforeMethod
	public void setUp() throws Exception {
		File file = new File("C:/Selenium/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		// Find the text input element by its name
		
		selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
        
        Assert.assertEquals("Cheese! - Google Search", driver.getTitle());
        
        

	}
	
	@AfterMethod
	@Ignore
	public void tearDown() throws Exception {
		selenium.stop();
	}

	@Test
	@Ignore
	public void testUntitled2() throws Exception {

		selenium.open("/");
	}

}
