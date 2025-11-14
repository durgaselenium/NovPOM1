package com.qa.opencart.nov1.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.nov1.constants.AppConstants;
import com.qa.opencart.nov1.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

private WebDriver driver;
private ElementUtil eleUtil;

//private By locators: page objects
private final By emailID = By.name("email");
private final By password = By.name("password");
private final By loginBtn = By.xpath("//input[@value='Login']");
private final By forgotPwdLink = By.linkText("Forgotten Password"); //2 Forgotten Password
private final By header = By.tagName("h2");
private final By registerLink = By.linkText("Register"); //2 Register

// Warning: No match for E-Mail Address and/or Password. ----->xpath
private final By loginErrorMessg = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

private static final Logger log = LogManager.getLogger(LoginPage.class);

//public constructor
public LoginPage(WebDriver driver) {
	this.driver = driver;
	eleUtil = new ElementUtil(driver);
}

//public page methods/actions:

@Step("getting login page title....")
public String getLoginPageTitle() {
 String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_WAIT);
 //System.out.println("login page title: " + title);
 log.info("login page title: " + title);
 return title;
 }

@Step("getting login url title....")
public String getLoginPageURL() {
 String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_WAIT);
 //System.out.println("login page url: " + url);
 log.info("login page url : " + url);
 return url;
}

@Step("forgot pwd link exist...")
public boolean isForgotPwdLinkExist() {
 return eleUtil.isElementDisplayed(forgotPwdLink);
}

@Step("page header exist...")
public boolean isheaderExist() {
 return eleUtil.isElementDisplayed(header);
}

@Step("login with correct username: {0} and password: {1}")
public AccountsPage doLogin(String appUsername,String appPassword) {
  log.info("application credentials: " + appUsername + " : " + "**************");
  eleUtil.waitForElementVisible(emailID, AppConstants.DEFAULT_MEDIUM_WAIT).sendKeys(appUsername);
  eleUtil.doSendKeys(password, appPassword);
  eleUtil.doClick(loginBtn);
   return new AccountsPage(driver);
 }

@Step("login with in-correct username: {0} and password: {1}")
public boolean doLoginWithInvalidCredentials(String invalidUN,String invalidPWD) {
 log.info("Invalid application credentials: " + invalidUN + " : " + invalidPWD);
 WebElement emailEle = eleUtil.waitForElementVisible(emailID, AppConstants.DEFAULT_MEDIUM_WAIT);
 emailEle.clear();
 emailEle.sendKeys(invalidUN);
 eleUtil.doSendKeys(password, invalidPWD);
 eleUtil.doClick(loginBtn);
 
 String errorMessg = eleUtil.doElementGetText(loginErrorMessg);
 log.info("invalid creds error messg: " + errorMessg);
 if(errorMessg.contains(AppConstants.LOGIN_INVALID_CREDS_MESSG)) {
	 return true;
 }
 else if (errorMessg.contains(AppConstants.LOGIN_INVALID_CREDS_MESSG)) {
	return true;
}
 return false;
 
}

public RegisterPage navigateToRegisterPage() {
	log.info("trying to navigation to register page...");
	eleUtil.waitForElementVisible(registerLink, AppConstants.DEFAULT_SHORT_WAIT).click();
	return new RegisterPage(driver);
}

}
