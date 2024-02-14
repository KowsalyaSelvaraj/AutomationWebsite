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

public class TestClass1 {


	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite 1 ");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite 1 ");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test 1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test 1");
	}

	@BeforeClass
	public void beforeClass()  {
		System.out.println("Before Class 1 ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class 1 ");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method 1 ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method 1 ");
	}

	@Test(groups = {"Smoke Test","Regression Test"})
	public void Test1() {
		System.out.println("This is test 1 method 1 ");
	}


	@Test(groups = {"Smoke Test"})
	public void Test2() {
		System.out.println("This is test 2 method 1 ");
	}
}
