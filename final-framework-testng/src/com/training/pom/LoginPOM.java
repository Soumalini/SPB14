package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
	private WebDriver driver; 
	private WebDriverWait wait;
	private FluentWait wt;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		wait=new WebDriverWait(driver,60);
		wt=new FluentWait(driver).pollingEvery(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(this.loginBtn));
		this.loginBtn.click(); 
	}
}
