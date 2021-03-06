package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminHomePOM {
	private WebDriver driver; 

	public AdminHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalog_icon; 

	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement catagories;

	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement clickTrash;


	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement addNewCategory;

	@FindBy(id="input-name1")
	private WebElement categoryName;

	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement categoryDescription;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement metaTagDesc;
	
	@FindBy(id="input-meta-keyword1")
	private WebElement metaTagkeyword;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveCategory;
	
	@FindBy(xpath="//a[contains(text(),'General')]")
	private WebElement generalTab;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement editButton;
	
	@FindBy(xpath="//a[@class='desc']")
	private WebElement categoryNameList;
//	
//	@FindBy(xpath="//li[@id='menu-catalog']//ul//li//a[contains(text(),'Recurring Profiles')]")
//	private WebElement recurringProfiles;

	@FindBy(xpath="//*[@id='content']/div[2]/div/div[2]/div/div[1]/ul/li[5]/span") ////*[@id="content"]/div[2]/div/div[2]/div/div[1]/ul/li[5]/span
	private WebElement clickTab;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement products;
	
	
	@FindBy(id="input-name")
	private WebElement productName;
	
	
	@FindBy(id="input-price")
	private WebElement productPrice;
	
	
	@FindBy(id="input-status")
	private WebElement productStatus;
	
	
	@FindBy(id="input-model")
	private WebElement productModel;
	
	
	@FindBy(id="input-quantity")
	private WebElement productQuantity;
	
	
	@FindBy(id="input-image")
	private WebElement productImage;
	
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement AddnewButton;
	
	

	public void clickCatalogicon() {
		this.catalog_icon.click(); 
	}

	public void clickCatagories() {
		this.catagories.click();

	}
	
	
	public void selectCheckBox() {
		Select sel=new Select(driver.findElement(By.name("selected[]"))); 
		sel.selectByVisibleText("INDIAN");
	}
	public void clickTrashButton() {
		this.clickTrash.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void addNewCategory() {
		this.addNewCategory.click();
	}
	
	public void categoryName(String categoryName) {
		this.categoryName.sendKeys(categoryName); 

	}
	public void categoryDescription(String categoryDescription) {
		this.categoryDescription.sendKeys(categoryDescription); 

	}
	public void metaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle); 

	}

	public void metaTagDesc(String metaTagDesc) {
		this.metaTagTitle.clear();
		this.metaTagDesc.sendKeys(metaTagDesc); 

	}

	public void metaTagkeyword(String metaTagkeyword) {
		this.metaTagkeyword.sendKeys(metaTagkeyword); 

	}
	public void dataTab() {
		this.dataTab.click();
	}
	
	public void designTab() {
		this.designTab.click();
	}
	public void generalTab() {
		this.generalTab.click();
	}
	public void saveCategory() {
		this.saveCategory.click();
	}
	
	public void verifyProductPresent() {
		String Verifytext= driver.findElement(By.xpath("//li[@id='menu-catalog']//ul//li//a[contains(text(),'Products')]")).getText();
		Assert.assertEquals(Verifytext, "Products");


	}
	public void verifyRecurringProfilesPresent() {
		String Verifytext= driver.findElement(By.xpath("//li[@id='menu-catalog']//ul//li//a[contains(text(),'Recurring Profiles')]")).getText();
		Assert.assertEquals(Verifytext, "Recurring Profiles");
	}

	public void editButton() {
		this.editButton.click();
	}
	public void verifySuccess() {

		String Verifytext=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(Verifytext.contains("Success: You have modified categories!"));
		System.out.println("success");

	}
	public void ClickTab() {
		this.clickTab.click();
	}
	
	public void clickProducts() {
		this.products.click();

	}
	
	public void productName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName); 

	}
	public void productPrice(String productPrice) {
		this.productPrice.clear();
		this.productPrice.sendKeys(productPrice); 

	}
	public void productStatus(String productStatus) {
		
		Select sel=new Select(driver.findElement(By.name("filter_status"))); 
		sel.selectByVisibleText(productStatus);
		//if(productPrice=515 && productImage='Enabled')
		

	}
	public void productModel(String productModel) {
		this.productModel.clear();
		this.productModel.sendKeys(productModel); 

	}
	public void productQuantity(String productQuantity) {
		//this.productQuantity.clear();
		this.productQuantity.sendKeys(productQuantity); 

	}
	public void productImage(String productImage) {
		//this.productImage.clear();
		Select sel=new Select(driver.findElement(By.name("filter_image"))); 
		sel.selectByVisibleText("Enabled");
		this.productImage.sendKeys(productImage); 

	}
	
	public void filter() {
		this.filter.click();
	}
	public void verifyProductName() {
		String Verifytext= driver.findElement(By.xpath("//*[@id='form-product']/div/table/tbody/tr[1]/td[3]")).getText();
		Assert.assertEquals(Verifytext, productName);
		
	}
	
	public void clickAddNewButton() {
		this.AddnewButton.click();

	}

	
}
