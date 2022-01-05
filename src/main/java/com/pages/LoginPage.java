package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// 1. By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPassword = By.linkText("Forgot your password?");

	// 2. Constructor of the Page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page actions: feature (behavior) of the page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPswdLinkExist() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}

	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}

	public void clickOnLoginButton() {
		driver.findElement(signInButton).click();
	}
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}


}
