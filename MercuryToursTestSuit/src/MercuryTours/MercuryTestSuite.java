package MercuryTours;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class MercuryTestSuite {

	public String baseUrl = "http://www.demoaut.com/";
	public String driverPath = "C:\\Users\\Pasindu\\Desktop\\QA-Test-Tools\\Driver\\chromedriver.exe";
	public WebDriver driver;
	
	
	//Elements in the page
	public String lnkRegister = "REGISTER";
	public String titleExpected = "Register: Mercury Tours";
	public String submitButton = "register";
	public String txtEmail = "email";
	public String txtPassword = "password";
	public String txtConfirmPassword = "confirmPassword";
	public String regSuccessMessage = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
	public String title;

	@BeforeSuite
	public void setupWebdriver() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void clickRegistration() {
//		System.out.println("ClickRegistration method");
		driver.findElement(By.linkText(lnkRegister)).click();
//		driver.get("http://demoaut.com/mercuryregister.php?osCsid=ee233d71f3ce2b52f2a68a55353ffe75");
		title = driver.getTitle().toString();
		assertEquals(title, titleExpected);
		assertTrue(driver.findElement(By.name(submitButton)).isDisplayed());
	}

	@Test(dependsOnMethods = {"clickRegistration"})
	@Parameters({"username","password","confirmpassword"})
	public void userRegistration(String username,String password ,String confirmpassword ) {
//		System.out.println("UserRegistration method");
		driver.findElement(By.name(txtEmail)).sendKeys("tstUser");
		driver.findElement(By.name(txtPassword)).sendKeys("abcxyz");
		driver.findElement(By.name(txtConfirmPassword)).sendKeys("abcxyz");
		driver.findElement(By.name(submitButton)).click();
//		System.out.println("---------- xpath view ---------");
		String xpath = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText();
//		System.out.println(xpath);
		assertEquals(regSuccessMessage, xpath);
		
	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
