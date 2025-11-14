package com.qa.opencart.nov1.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.nov1.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	//public constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
}
