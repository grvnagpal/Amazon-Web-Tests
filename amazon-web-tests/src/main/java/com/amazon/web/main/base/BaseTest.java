package com.amazon.web.main.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.amazon.web.framework.common.logger.Logger;

public class BaseTest {
	public WebDriver driver;
	public Properties properties = new Properties();
	
	private void logAboutTest() {
        Logger.info("Running tests on Amazon.in");
    }
	
	@BeforeSuite
    public void beforeSuite() {
        this.logAboutTest();
    }
	
	@BeforeMethod(alwaysRun = true)
	public void setupWebDriver() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		properties.load(new FileReader(new File("test.properties")));
	}
	

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
		 
}