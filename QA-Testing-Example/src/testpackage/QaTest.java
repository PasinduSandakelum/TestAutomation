package testpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QaTest {
//	public String baseUrl = "http://demoaut.com/";
	public String baseUrl = "https://www.sophiatesting.com/en/demo";
	String driverPath = "C:\\Users\\Pasindu\\Desktop\\QA-Test-Tools\\Driver\\chromedriver.exe";
	public WebDriver driver;

	@Test
	public void addTestDriver() {
		System.out.println("Launching Chrome....");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void addTest1() {
		System.out.println("------Test Method 1-----");
//		assertTrue(false);
	}

	@Test
	public void addTest2() {
		System.out.println("------Test Method 2-----");
//		assertTrue(true);
	}

	@Test
	public void addTest3() {
		System.out.println("------Test Method 3-----");
//		assertEquals(true, false);
	}

	@AfterMethod
	public void addTestAfter() {
		System.out.println("xxxxx After mothod xxxxx");
	}

	@BeforeMethod
	public void addTestBefore() {
		System.out.println("xxxxx before method xxxxx");
	}

	@AfterTest
	public void addTestAfterMethod() {
		System.out.println("<<<<< After Test >>>>>");
	}

	@BeforeTest
	public void addTestBeforeMethod() {
		System.out.println("<<<<< Before Test >>>>>");
	}

	@AfterClass
	public void addTestAfterClass() {
		System.out.println("///// After Class /////");
	}

	@BeforeClass
	public void addTestBeforeClass() {
		System.out.println("///// Before Class /////");
	}
}
