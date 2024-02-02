package com.amazon.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ToolTipPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/tool-tips");

		driver.navigate().refresh();
		
		WebElement element =  driver.findElement(By.id("toolTipTextField"));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		
	 String string =	element.getAttribute("title");
		
		System.out.println(string+" is the data");
		

	}

}
