package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM adminLoginPOM;
	private AdminHomePOM adminHomePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM(driver); 
		adminHomePOM=new AdminHomePOM(driver);
		baseUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		validLoginTest();
		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	private void validLoginTest() throws InterruptedException {
		
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("AdminLogin");

	}
	@Test(priority=1)
	public void deleteCategoryTest() throws InterruptedException {
		
		adminHomePOM.clickCatalog_icon();
		adminHomePOM.clickCatagories();
		adminHomePOM.clickTrashButton();
		screenShot.captureScreenShot("DeleteCategory");
	}
}
