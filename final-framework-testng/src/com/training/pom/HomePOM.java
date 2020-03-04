package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePOM {
	private WebDriver driver; 
	
	public HomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user-o")
	private WebElement user_icon; 
	
		
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
	
}
