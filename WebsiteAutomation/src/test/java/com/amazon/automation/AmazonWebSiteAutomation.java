package com.amazon.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWebSiteAutomation {

	@Test
	public void runTest() {
		// https://demoqa.com/broken
		 WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kowsalyas\\Drivers\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("https://demoqa.com/");

		String titleString = driver.getTitle();

		System.out.println(titleString);
	}

	public static void main(String[] args) {

		// https://demoqa.com/broken
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kowsalyas\\Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		
	//	WebDriver driver = new ChromeDriver(optionsBeta);

		
		// ChromeOptions options = new ChromeOptions();
		 options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\new_chrome.exe");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--ignore-ssl-errors=yes");
		 options.addArguments("--ignore-certificate-errors");
		  options.addArguments("--disable-dev-shm-usage"); 
		  WebDriver driver = new  ChromeDriver(options);
		
		driver.navigate().to("https://demoqa.com/");

		String titleString = driver.getTitle();

		System.out.println(titleString);

	}
}
