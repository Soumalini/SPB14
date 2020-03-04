package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {
	private WebDriver driver; 

	public MyAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changePassword; 

	@FindBy(name="password")
	private WebElement password;

	@FindBy(name="confirm")
	private WebElement confirmPassword;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement clickOnContinue;

	public void changePassword() {

		this.changePassword.click();

	}
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);

	}
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);

	}
	public void clickOnContinue() {
		this.clickOnContinue.click();

	}



}
