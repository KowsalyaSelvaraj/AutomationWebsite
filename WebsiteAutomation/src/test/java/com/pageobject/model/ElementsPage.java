package com.pageobject.model;

import org.openqa.selenium.support.PageFactory;

import com.amazon.automation.AmazonWebSiteAutomation;

public class ElementsPage {

	
	public ElementsPage() {
		PageFactory.initElements(AmazonWebSiteAutomation.driver, getClass());
	}
}
