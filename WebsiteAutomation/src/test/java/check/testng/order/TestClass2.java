package check.testng.order;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass2 {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("Before Suite 2");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("after Suite 2");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test 2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test 2");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class  2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class 2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method 2");
	}

	@Test(groups = {"Smoke Test","Regression Test"})
	public void Test1() {
		System.out.println("This is test 1 method 2");
	}


	@Test(groups = {"Smoke Test"})
	public void Test2() {
		System.out.println("This is test 2 method 2");
	}
}
