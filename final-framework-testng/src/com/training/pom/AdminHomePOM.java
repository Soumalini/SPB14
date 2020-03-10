package com.training.pom;

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
	

	public void clickCatalog_icon() {
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
		this.metaTagTitle.sendKeys(metaTagTitle); 

	}

	public void metaTagDesc(String metaTagDesc) {
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
	


}
