package com.qa.opencart.nov1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.nov1.base.BaseTest;
import com.qa.opencart.nov1.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EP-100: Design the Open Cart App Login Page")
@Feature("F-101: design open cart login feature")
@Story("US-50: develop login core feature: title,url, user is able to login")
public class LoginPageTest extends BaseTest {

 @Description("login page title test...")
 @Owner("Durga Sridevi Veeravalli")
 @Severity(SeverityLevel.MINOR)	
 @Test
 public void loginPageTitleTest() {
 String actTitle = loginPage.getLoginPageTitle();
 ChainTestListener.log("login page title: "+ actTitle);
 Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
 }	

 @Description("login page url test...")
 @Owner("Durga Sridevi Veeravalli")
 @Severity(SeverityLevel.NORMAL)
 @Test
public void loginPageURLTest() {
 String actURL = loginPage.getLoginPageURL();
 ChainTestListener.log("login page url: " + actURL);
 Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
}
 
 @Description("forgot password link exist test...")
 @Owner("Durga Sridevi Veeravalli")
 @Severity(SeverityLevel.CRITICAL)
 @Test
public void isForgotPwdLinkExistTest() {
 Assert.assertTrue(loginPage.isForgotPwdLinkExist());	
} 
 
 @Description("login page header test....")
 @Owner("Durga Sridevi Veeravalli")
 @Severity(SeverityLevel.MINOR)
 @Test
public void isLoginPageHeaderExistTest() {
 Assert.assertTrue(loginPage.isheaderExist());	
} 
 
 @Description("user is able to login to app with the correct credentials...")
 @Owner("Durga Sridevi Veeravalli")
 @Severity(SeverityLevel.BLOCKER)
 @Test
 public void loginTest() {
 accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
 Assert.assertTrue(accPage.isLogoutLinkExist());
 }
	
}
