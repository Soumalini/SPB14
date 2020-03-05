package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePOM {
	private WebDriver driver; 
	
	public HomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user-o")
	private WebElement user_icon; 
	
	@FindBy(xpath="//a[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement product;
	
	@FindBy(id="button-cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement viewCart;

	
	
	
	public void clickuserIcon() {
		this.user_icon.click(); 
		 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.xpath("//div[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a"));
		 actions.moveToElement(menuOption).perform();
	}
		
    public void clickRegisterButton() {
    	 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.cssSelector(".tb_menu_system_account_login .tb_text"));
		 actions.moveToElement(menuOption).perform();
		
	}
    public void clickOnProduct() {
		this.product.click(); 
		
	}
    public void clickAddToCartButton() {
    	this.addToCartButton.click();
    }
    public void moveToCartIcon() {
    	Actions actions = new Actions(driver);
    	WebElement menuOption = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
    	actions.moveToElement(menuOption).perform();
    }
    public void clickViewCartButton() {
    	this.viewCart.click();
    }
    public void verifyProdutDetails() {
    	String productname=driver.findElement(By.xpath("//div[@class='cart-info tb_min_w_500']//a[contains(text(),'Integer vitae iaculis massa')]")).getText();
		String actualname="Integer vitae iaculis massa";
		Assert.assertEquals(actualname, productname);
    }
	
}
