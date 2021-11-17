package com.webapp.test.medicare;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MedicareUserTest {

	String siteUrl = "http://localhost:4200/";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	void testMedicareHomepage() {
		// step 5 : Evaluate a test
		String expected = "MedicareAngular";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testHompageSource() {
		// step 5 : Evaluate a test
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Test
	void testLoginButton() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[5]"));
		searchBox.click();

		assertEquals("http://localhost:4200/login", driver.getCurrentUrl());
	}
	@Test
	void testSignUpButton() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[4]"));
		searchBox.click();

		assertEquals("http://localhost:4200/register", driver.getCurrentUrl());
	}
	@Test
	void testAboutButton() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[1]"));
		searchBox.click();

		assertEquals("http://localhost:4200/about", driver.getCurrentUrl());
	}
	
	@Test
	void testUserLoginElements() throws InterruptedException {

		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[5]"));
		searchBox.click();
		WebElement emailInput = driver.findElement(By.name("nameforusername"));
		WebElement passwordInput = driver.findElement(By.name("nameforpassword"));
		WebElement submitButton = driver.findElement(By.cssSelector("body > app-root > app-login > div > div > form > button"));
		
		assertEquals(true, emailInput.isDisplayed());
		assertEquals(true, passwordInput.isDisplayed());
		assertEquals(true, submitButton.isDisplayed());
	}
	@Test
	void testUserLogin() throws InterruptedException  {
		// step 5 : evaluate test
	
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[5]"));
		searchBox.click();
		WebElement emailInput = driver.findElement(By.name("nameforusername"));
		WebElement passwordInput = driver.findElement(By.name("nameforpassword"));
		WebElement submitButton = driver.findElement(By.cssSelector("body > app-root > app-login > div > div > form > button"));
	
		emailInput.sendKeys("Bharath");
		
		passwordInput.sendKeys("Bharath@1234");
		
		submitButton.submit();
		Thread.sleep(1000);
		assertEquals( driver.getCurrentUrl(),"http://localhost:4200/user/home");
	}
	@Test
	void testUserSignUp() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[4]"));
		searchBox.click();
		WebElement firstNameInput = driver.findElement(By.name("namefname"));
		WebElement lastNameInput = driver.findElement(By.name("namelastname"));
		WebElement phoneNumberInput = driver.findElement(By.name("namephoneno"));
		WebElement emailInput = driver.findElement(By.name("nameemail"));
		
		
		assertEquals(true, firstNameInput.isDisplayed());
		assertEquals(true, lastNameInput.isDisplayed());
		assertEquals(true, phoneNumberInput.isDisplayed());
		assertEquals(true, emailInput.isDisplayed());
	
		
	}
	@Test
	void testUserCart() throws InterruptedException  {
		// step 5 : evaluate test
	
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/myindex/div[1]/h3/a[5]"));
		searchBox.click();
		WebElement emailInput = driver.findElement(By.name("nameforusername"));
		WebElement passwordInput = driver.findElement(By.name("nameforpassword"));
		WebElement submitButton = driver.findElement(By.cssSelector("body > app-root > app-login > div > div > form > button"));
	
		emailInput.sendKeys("Bharath");
		
		passwordInput.sendKeys("Bharath@1234");
		
		submitButton.submit();
		Thread.sleep(1000);
		WebElement searchBox1 = driver.findElement(By.cssSelector("body > app-root > app-user-home > app-user-dashboard > div > h3 > a.mat-focus-indicator.mat-badge.mat-button.mat-button-base.mat-primary.mat-badge-warn.mat-badge-overlap.mat-badge-above.mat-badge-after.mat-badge-medium"));
		searchBox1.click();
		
		assertEquals( driver.getCurrentUrl(),"http://localhost:4200/user/checkout");
	}
	
}
