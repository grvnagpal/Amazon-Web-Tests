package com.amazon.web.main.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonObjects {
	WebDriver driver;

	@FindBy(xpath = "//span[@class='nav-sprite nav-logo-base' and text() = 'Amazon']")
	public WebElement webSiteName;

	@FindBy(xpath = "//span[@class='nav-line-1' and text()='Hello. Sign in']")
	public WebElement signInButton;

	@FindBy(xpath = "//*[@id='createAccountSubmit']")
	public WebElement createAccount;

	@FindBy(id = "ap_email")
	public WebElement email;

	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "ap_password")
	public WebElement password;

	@FindBy(id = "signInSubmit")
	public WebElement submitButton;

	@FindBy(xpath = "//span[@class='nav-line-1' and text()='Hello, Gaurav']")
	public WebElement logInPageUserName;

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(xpath = "//input[@type='submit' and @class = 'nav-input']")
	public WebElement searchButton;

	@FindBy(xpath = "(//span[@class='a-color-state a-text-bold' and text() = '\"Apple Watch\"'])[2]")
	public WebElement appleWatchSearchResult;

	@FindBy(xpath = "//*[@class='s-item-container']")
	public List<WebElement> numberOfProducts;

	@FindBy(id = "productTitle")
	public WebElement productTitle;

	@FindBy(xpath = "//span[@class='a-text-strike']")
	public WebElement productMRP;

	@FindBy(id = "acrCustomerReviewText")
	public WebElement actualRatings;

	public AmazonObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}