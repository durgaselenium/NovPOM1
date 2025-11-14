package com.qa.opencart.nov1.constants;

import java.util.List;

public class AppConstants {

 public static final int DEFAULT_SHORT_WAIT = 5;
 public static final int DEFAULT_MEDIUM_WAIT = 10;
 public static final int DEFAULT_LARGE_WAIT = 5;
	
 public static final int DEFAULT_FOOTER_LINK_COUNT = 15;
 
 public static final String LOGIN_PAGE_TITLE = "Account Login";
 public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
 
 public static final String LOGIN_INVALID_CREDS_MESSG = "Warning: No match for E-Mail Address and/or Password.";
 
 public static final int ACC_PAGE_HEADERS_COUNT = 4;
 public static List<String> expectedAccPageHeadersList = List.of("My Account", 
			"My Orders",
			"My Affiliate Account",
			"Newsletter");

	
}
