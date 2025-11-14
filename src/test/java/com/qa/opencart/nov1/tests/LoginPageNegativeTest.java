package com.qa.opencart.nov1.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.nov1.base.BaseTest;

public class LoginPageNegativeTest extends BaseTest {

@DataProvider	
public Object[][] getNegativeLoginData(){
 return new Object[][] {
	 {"lalithadevi@gmail.com","test@123"},
	 {"oct2025@open.com","test@123"},
	 {"act2025@open.com","test@@1234"},
	 {"","test@123"},
	 {"",""}
 };	
	
}	

 @Test(dataProvider = "getNegativeLoginData")	
 public void negativeLoginTest(String inValidUN,String invalidPWD) {
	Assert.assertTrue(loginPage.doLoginWithInvalidCredentials(inValidUN, invalidPWD)); 
 }
	
}
