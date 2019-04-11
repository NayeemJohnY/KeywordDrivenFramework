package com.qa.HubSpot.tests;

import org.testng.annotations.Test;

import com.qa.HubSpot.Engine.KeywordEngine;

public class LoginTest {
	public KeywordEngine  keywordEngine;
	@Test
	public void loginTest()
	{
		keywordEngine=new KeywordEngine();
		keywordEngine.startExecution("login");

	}

}
