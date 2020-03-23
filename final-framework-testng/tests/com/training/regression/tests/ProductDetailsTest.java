package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.ProductDetailsDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductDetailsTest {
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
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	private void validLoginTest() throws InterruptedException {

		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("AdminLogin");
	}


	@Test(dataProvider = "ProductDetailsData", dataProviderClass = ProductDetailsDataProviders.class)
	public void productDeatilsTest(String productName, String productPrice,String productStatus,String productModel,String productQuantity,String productImage) throws InterruptedException {

		if(productName==null || productName.equalsIgnoreCase("null") || productName.equals("")) {
			productName="";
		}if(productPrice==null || productPrice.equalsIgnoreCase("null") || productPrice.equals("")) {
			productPrice="";
		}if(productQuantity==null || productQuantity.equalsIgnoreCase("null") || productQuantity.equals("")) {
			productQuantity="";
		}if(productModel==null || productModel.equalsIgnoreCase("null") || productModel.equals("")) {
			productModel="";
		}
		
		System.out.println("product name= "+productName + "  productPrice="+productPrice+ "   productstatus="+productStatus);
		validLoginTest();
		adminHomePOM.clickCatalogicon();

		adminHomePOM.clickProducts();
		adminHomePOM.productName(productName);
		adminHomePOM.productPrice(productPrice);
		adminHomePOM.filter();
		adminHomePOM.productStatus(productStatus);
		adminHomePOM.productModel(productModel);
		adminHomePOM.productQuantity(productQuantity);
		adminHomePOM.productImage(productImage);
		adminHomePOM.filter();

		// get the product names from UI output list

		//verify if the searched product name is matching with test data product name


		screenShot.captureScreenShot("ProductDetails");

	}

}