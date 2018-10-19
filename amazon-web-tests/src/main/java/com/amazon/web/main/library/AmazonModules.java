package com.amazon.web.main.library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.amazon.web.framework.common.logger.Logger;
import com.amazon.web.main.base.Base;
import com.amazon.web.main.objects.AmazonObjects;

public class AmazonModules extends Base {
	private List<WebElement> ls;
	AmazonObjects amazonObj;
	public Properties properties = new Properties();

	public AmazonModules(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "quickEnrollChkBx")
	private WebElement quickEnrollCheck;

	public void openAmazonWebSite() {
		amazonObj = new AmazonObjects(this.driver);
		Logger.info("Opening Amazon.in");
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Logger.info("Verifying Website Title");
		try {
			driver.getTitle().contains("Amazon.in");
		} catch (Exception e) {
			Assert.fail("Website title is not as expected");
		}

		Logger.info("Verifying Website Name is being displayed on the top left side");
		try {
			amazonObj.webSiteName.isDisplayed();
			Logger.info("Website Name is being displayed on the top left side.");
		} catch (Exception e) {
			Assert.fail("Website name is not being displayed on the webpage.");
		}

	}

	public void signInAmazon() throws FileNotFoundException, IOException {
		amazonObj = new AmazonObjects(this.driver);
		properties.load(new FileReader(new File("test.properties")));
		Logger.info("Click on Sign In Button");
		try {
			// driver.findElement(By.xpath("//span[@class='nav-line-1' and text()='Hello.
			// Sign in']")).click();
			amazonObj.signInButton.click();
			amazonObj.createAccount.isDisplayed();
			Logger.info("Sign In Page is opened.");
		} catch (Exception e) {
			Assert.fail("Sign In Page is not opened.");
		}

		Logger.info("Logging Into Amazon.in");
		amazonObj.email.sendKeys(properties.getProperty("username"));
		amazonObj.continueButton.click();

		amazonObj.password.sendKeys(properties.getProperty("password"));
		amazonObj.submitButton.click();
		amazonObj.logInPageUserName.isDisplayed();
		Logger.info("User is Logged in Successfully.");
	}

	public void searchProduct() {
		amazonObj = new AmazonObjects(this.driver);
		Logger.info("Searching the Product - Apple Watch");
		amazonObj.searchBox.sendKeys(properties.getProperty("productName"));
		amazonObj.searchButton.click();
		try {
			amazonObj.appleWatchSearchResult.isDisplayed();
			Logger.info("Apple Watch Search is successful.");
		} catch (Exception e) {
			Assert.fail("Apple Watch Search is not successful.");
		}
	}

	public void numberOfProductsOnSearchResultPage() {
		amazonObj = new AmazonObjects(this.driver);
		Logger.info("Getting the List of Products");
		try {
			ls = amazonObj.numberOfProducts;
			Logger.info("Fetching the List of Products is Successful");
		} catch (Exception e) {
			Assert.fail("Fetching the List of Products is not successful");
		}
		Logger.info("Total Number of Items displayed on the webpage are: " + ls.size());
	}

	public void validateSecondProductInformation() throws InterruptedException {
		amazonObj = new AmazonObjects(this.driver);
		Logger.info("Click on 2nd Item on a webpage");
		WebElement secondElementInList = ls.get(1);
		Thread.sleep(3000);
		new Actions(this.driver).moveToElement(secondElementInList).moveByOffset(-50, -50).click().perform();
		Logger.info("Validating the product details");
		ArrayList<String> tabs = new ArrayList<String>(this.driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String actualProductTitle = amazonObj.productTitle.getText();
		assertTrue(actualProductTitle.contains(properties.getProperty("expectedProductName")));
		String actualMRP = amazonObj.productMRP.getText();
		assertTrue(actualMRP.contains(properties.getProperty("expectedMRP")));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public void validateThirdProductRatings() {
		amazonObj = new AmazonObjects(this.driver);
		Logger.info("Validating the user ratings of 3rd Product.");
		WebElement thirdElementInList = ls.get(2);
		new Actions(this.driver).moveToElement(thirdElementInList).moveByOffset(-50, -50).click().perform();
		Logger.info("Validating the ratings.");
		ArrayList<String> tabs = new ArrayList<String>(this.driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String actualRatings = amazonObj.actualRatings.getText();
		assertTrue(actualRatings.contains(properties.getProperty("expectedProductRating")));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

}