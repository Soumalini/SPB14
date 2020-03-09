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
	


}
