package com.pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.automation.*;

public class HomePage {

	
	public HomePage() {
		PageFactory.initElements(AmazonWebSiteAutomation.driver, this);
	}
	
	
	@FindBy(xpath = "//*[text()='Elements']//preceding::div[1]")
	private WebElement elementsElement;
	
	@FindBy(xpath = "//*[text()='Forms']//preceding::div[1]")
	private WebElement formsElement;
	
	@FindBy(xpath = "//*[text()='Alerts, Frame & Windows']//preceding::div[1]")
	private WebElement alertsFrameWindowsElement;
	
	//*[text()='Widgets']//preceding::div[1]

	@FindBy(xpath = "//*[text()='Widgets']//preceding::div[1]")
	private WebElement widgetsElement;
	
	@FindBy(xpath = "//*[text()='Interactions']//preceding::div[1]")
	private WebElement interactionsElement;
	
	@FindBy(xpath = "Book Store Application")
	private WebElement bookStoreApplicationElement;

	/**
	 * @return the elementsElement
	 */
	public WebElement getElementsElement() {
		return elementsElement;
	}

	/**
	 * @return the formsElement
	 */
	public WebElement getFormsElement() {
		return formsElement;
	}

	/**
	 * @return the alertsFrameWindowsElement
	 */
	public WebElement getAlertsFrameWindowsElement() {
		return alertsFrameWindowsElement;
	}

	/**
	 * @return the widgetsElement
	 */
	public WebElement getWidgetsElement() {
		return widgetsElement;
	}

	/**
	 * @return the interactionsElement
	 */
	public WebElement getInteractionsElement() {
		return interactionsElement;
	}

	/**
	 * @return the bookStoreApplicationElement
	 */
	public WebElement getBookStoreApplicationElement() {
		return bookStoreApplicationElement;
	}
	
	//Getter methods
	
}
