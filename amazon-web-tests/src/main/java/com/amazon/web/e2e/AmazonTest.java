package com.amazon.web.e2e;

import org.testng.annotations.Test;

import com.amazon.web.main.base.BaseTest;
import com.amazon.web.main.library.AmazonModules;

public class AmazonTest extends BaseTest {

	@Test
	public void testAmazonInWebsite() throws Exception {
		AmazonModules amazonModule = new AmazonModules(this.driver);

		//Open www.amazon.in
		amazonModule.openAmazonWebSite();
		
		//Sign In Amazon.in
		amazonModule.signInAmazon();
		
		//Search a product on Amazon. in say Apple Watch
		amazonModule.searchProduct();
		
		//Get the number of products displayed on the web page.
		amazonModule.numberOfProductsOnSearchResultPage();

		//Validate the details of the second product displayed on the Search Results.
		amazonModule.validateSecondProductInformation();
		
		//Validate the number of customer reviews on the third product.
		amazonModule.validateThirdProductRatings();

	}

}