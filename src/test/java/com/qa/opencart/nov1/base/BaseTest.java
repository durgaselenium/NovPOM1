package com.qa.opencart.nov1.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.nov1.factory.DriverFactory;
import com.qa.opencart.nov1.pages.AccountsPage;
import com.qa.opencart.nov1.pages.LoginPage;
import com.qa.opencart.nov1.pages.ProductInfoPage;
import com.qa.opencart.nov1.pages.RegisterPage;
import com.qa.opencart.nov1.pages.SearchResultsPage;

import io.qameta.allure.Description;

public class BaseTest {

protected WebDriver driver;
protected Properties prop;
DriverFactory df;

protected LoginPage loginPage;
protected AccountsPage accPage;
protected SearchResultsPage searchResultsPage;
protected RegisterPage registerPage;
protected ProductInfoPage productInfoPage;


@Description("launch the browser: {0} and url")
@Parameters({"browser"})
@BeforeTest
public void setUp(@Optional("chrome") String browserName) {
	df = new DriverFactory();
    prop = df.initProp();
	
    if(browserName!=null) {
    	prop.setProperty("browser", browserName);
    }
    driver = df.initDriver(prop);
    loginPage = new LoginPage(driver);
}

@AfterMethod // will be running after each @test method
public void attachScreenshot(ITestResult result) {
	if(!result.isSuccess()) {  //only for failure test cases -- true
		ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
	}
	//ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
}

@Description("closing the browser...")
@AfterTest
public void tearDown() {
	driver.quit();
}
	
	
}
