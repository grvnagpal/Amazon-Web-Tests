package com.amazon.web.main.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
    public final WebDriver getDriver() {
        return this.driver;
    }
    
    public final String getTitle() {
        return this.driver.getTitle();
    }

}