package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPOM {
	private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name1")
	private WebElement productName; 
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	
	@FindBy(name="category")
	private WebElement category;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linksTab;
				
	@FindBy(linkText="Attribute")
	private WebElement attributeTab;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Option')]")
	private WebElement optionTab;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Recurring')]")
	private WebElement recurringTab;
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement discountTab;
	
	@FindBy(xpath="//a[contains(text(),'Special')]")
	private WebElement specialTab;
	
	@FindBy(xpath="//a[contains(text(),'Image')]")
	private WebElement imageTab;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	private WebElement rewardPointsTab;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveIcon;
	
	
	

	public void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	public void metaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	public void modelName(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	public void price(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	
	public void quantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	public void categories(String category) {
				
		this.category.clear();
		this.category.sendKeys(category);
	}
	public void clickOnDataTab() {
		this.dataTab.click(); 
		
	}
	public void clickOnlinksTab() {
		this.linksTab.click(); 
		
	}
	public void clickOnAttributeTab() {
		this.attributeTab.click(); 
		
	}
	public void clickOnOptionTab() {
		this.optionTab.click(); 
		
	}
	public void clickOnRecurringTabTab() {
		this.recurringTab.click(); 
		
	}
	public void clickOnDiscountTab() {
		this.discountTab.click(); 
		
	}
	public void clickOnSpecialTab() {
		this.specialTab.click(); 
		
	}
	public void clickOnImageTab() {
		this.imageTab.click(); 
		
	}
	public void clickOnRewardPointsTab() {
		this.rewardPointsTab.click(); 
		
	}
	public void clickOndesignTab() {
		this.designTab.click(); 
		
	}
	public void saveIcon() {
		this.saveIcon.click();
	}
	
	public void verifySuccess() {

		String Verifytext=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(Verifytext.contains("Success: You have modified products!"));
		System.out.println("success");

	}
	
   
    public void verifyProdutDetails() {
    	String productname=driver.findElement(By.xpath("//div[@class='cart-info tb_min_w_500']//a[contains(text(),'Integer vitae iaculis massa')]")).getText();
		String actualname="Integer vitae iaculis massa";
		Assert.assertEquals(actualname, productname);
    }
	
}
