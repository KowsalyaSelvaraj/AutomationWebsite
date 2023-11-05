package com.amazon.automation;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobject.model.HomePage;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWebSiteAutomation {

	public static WebDriver driver;
	public static String finalStatus="";

	@BeforeTest
	public void setUpDriver() {
		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("requireWindowFocus", true);

		driver = new FirefoxDriver(options);

		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");

		String titleString = driver.getTitle();

		System.out.println("Title of the window"+titleString);
	}

	@AfterTest
	public void closeDriver() {
		if(!finalStatus.equalsIgnoreCase("fail")) {
			//	driver.quit();
		}
	}


	@Test(enabled = false)
	public void openMultipleWindows() {

		//window to focus not working
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.focus();","");

		String parentTabString = driver.getWindowHandle();
		//open a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		int numberOfWindowsOpened =  driver.getWindowHandles().size();
		System.out.println("Number of windows opened "+numberOfWindowsOpened);

		for(String windowString : driver.getWindowHandles()) {
			if(windowString.equals(parentTabString))
				driver.switchTo().window(parentTabString);
		}

	}

	@Test
	public void elementsTextBox() {
		try {
			HomePage homePage = new HomePage();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

			homePage.getElementsElement().click();


			driver.findElement(By.xpath("//span[text()='Text Box']")).click();

			String usernameAttributeString =	driver.findElement(By.id("userName")).getAttribute("placeholder");
			System.out.println(usernameAttributeString);
			driver.findElement(By.id("userName")).sendKeys("Kowsalya S");
			driver.findElement(By.id("userEmail")).sendKeys("kowsalya@gmail.com");
			driver.findElement(By.id("currentAddress")).sendKeys("Chennai");

			executor.executeScript("arguments[0].value='Chennai TN'", driver.findElement(By.id("permanentAddress")));

			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("submit")));
			driver.findElement(By.id("submit")).click();

			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='output']")));
			List<WebElement> outputElements =	driver.findElements(By.xpath("//*[@id='output']//child::p"));
			String inputedData="";
			for(WebElement element : outputElements) {
				inputedData += element.getText();
			}
			System.out.println("Inputed data => "+inputedData);

		}catch (Exception e) {
			finalStatus  = "Fail";
		}
	}

	@Test
	public void checkBoxes() {
		try {
			HomePage homePage = new HomePage();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

			homePage.getElementsElement().click();


			driver.findElement(By.xpath("//span[text()='Check Box']")).click();

			driver.findElement(By.xpath("//*[text()='Home']//preceding::button[1]")).click();
			driver.findElement(By.xpath("//*[text()='Desktop']//preceding::span[2]")).click();

			List<WebElement> resultElements = driver.findElements(By.xpath("//div[@id='result']/span"));


			for(WebElement element : resultElements) {
				System.out.println(element.getText());
			}
		}catch (Exception e) {
			finalStatus  = "Fail";
		}
	}

	@Test
	public void radioButton() {
		HomePage homePage = new HomePage();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

		homePage.getElementsElement().click();

		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

		List<WebElement> resultElements =	driver.findElements(By.xpath("//div[text()='Do you like the site?']//following::input//following-sibling::label"));

		for(WebElement element : resultElements) {
			if(element.getText().equalsIgnoreCase("yes")) {
				element.click();
				break;
			}
		}

		System.out.println("You have selected =>"+driver.findElement(By.xpath("//p[@class='mt-3']/span")).getText());
	}

	@Test
	public void buttonActions() {
		try {
			HomePage homePage = new HomePage();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

			homePage.getElementsElement().click();

			executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Buttons']")));
			driver.findElement(By.xpath("//span[text()='Buttons']")).click();

			driver.findElement(By.id("doubleClickBtn"));

			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).build().perform();

			action.contextClick(driver.findElement(By.id("rightClickBtn"))).build().perform();

			action.click(driver.findElement(By.xpath("//button[text()='Click Me']"))).build().perform();

		
			List<WebElement> resultElements =	driver.findElements(By.xpath("//button[@id='3TPb8']//following::p"));
			for(WebElement element : resultElements) {
				System.out.println(element.getText());
			}
		}catch (Exception e) {
			System.out.println(e);
			finalStatus  = "Fail";
		}
	}

	@Test
	public void LinksAndImages() {
		try {
			HomePage homePage = new HomePage();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

			homePage.getElementsElement().click();

			executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Broken Links - Images']")));
			driver.findElement(By.xpath("//span[text()='Broken Links - Images']")).click();

			//gives naturalWidth some value say 347
			String naturalWidthOfValidImageString = driver.findElement(By.xpath("//p[text()='Valid image']/following-sibling::img[1]")).getAttribute("naturalWidth");
			//gives naturalWidth as 0
			String naturalWidthOfInvalidImageString =  driver.findElement(By.xpath("//p[text()='Broken image']/following-sibling::img[1]")).getAttribute("naturalWidth");

			System.out.println(naturalWidthOfInvalidImageString +" and "+naturalWidthOfValidImageString);

			//Links
			driver.findElement(By.xpath("//p[text()='Valid Link']/following-sibling::a[1]")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));

			System.out.println("Number of windows opened "+driver.getWindowHandles().size());

		}catch (Exception e) {
			System.out.println(e);
			finalStatus  = "Fail";
		}
	}

	@Test
	public void uploadAndDownload() throws AWTException, InterruptedException {

		HomePage homePage = new HomePage();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getElementsElement());

		homePage.getElementsElement().click();

		executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Upload and Download']")));
		driver.findElement(By.xpath("//span[text()='Upload and Download']")).click();

		//click on download button
		driver.findElement(By.id("downloadButton")).click();

		Thread.sleep(5000);

		File file = new File("C:\\Users\\lap\\Downloads");
		File[] files = file.listFiles();
		long lastModified = Long.MIN_VALUE;
		String downloadedFile="";

		for(File file2 : files) {

			if(file2.lastModified()>lastModified) 
			{
				System.out.println(file2.getName());
				downloadedFile = file2.getName();
				lastModified = file2.lastModified();
			}
		}
		System.out.println(lastModified);

		if(downloadedFile.contains("sample")) {
			System.out.println("file downloaded ");
		}else {
			System.out.println("file not downloaded");
		}

		//upload the file
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Select a file']")).click();

		StringSelection stringSelection = new StringSelection("C:\\Users\\lap\\Downloads\\Openpyxl.txt");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		System.out.println("value of uploaded file "+driver.findElement(By.id("uploadFile")).getAttribute("value"));
	}
	
	@Test
	public void waitCondition() throws AWTException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(20));
		
			
		
	}
	
	@Test
	public void relativeLocatorsSelenium4() throws AWTException, InterruptedException {

		HomePage homePage = new HomePage();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", homePage.getFormsElement());

		homePage.getFormsElement().click();

		executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Practice Form']")));
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();

		
		WebElement element = driver.findElement(By.id("lastName"));
		
		WebElement element2 = driver.findElement(RelativeLocator.with(By.id("userEmail")).below(element));
		
		
	//	RelativeLocator.with(By.tagName("input")).above(By.id("password"));
		
		if(element2.getAttribute("value")!=null) {
			System.out.println("hello bro");
		}
		element2.sendKeys("kowsalyas@gmail.com");
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}