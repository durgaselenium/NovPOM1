package com.qa.opencart.nov1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.nov1.constants.AppConstants;
import com.qa.opencart.nov1.utils.ElementUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	//public constructor
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}	
	
	private final By searchResults = By.cssSelector("product-thumb");//3 images--MacBook,MacBook Air,MacBook Pro
    private final By resultsHeaders = By.tagName("h1"); //Search-macbook
    
    public int getSearchResultsCount() {
    int resultCount = eleUtil.waitForElementsPresence(searchResults, AppConstants.DEFAULT_MEDIUM_WAIT).size();
    return resultCount;		
    }

    public String getResultsHeaderValue() {
     String header = eleUtil.doElementGetText(resultsHeaders);
     System.out.println("results count --->"+ header);
     return header;
    }
    
    public ProductInfoPage selectProduct(String productName) {
    System.out.println("product name -->" + productName);
    eleUtil.doClick(By.linkText(productName)); //3 images--MacBook,MacBook Air,MacBook Pro
    return new ProductInfoPage(driver);
    	
    }
    
}
