package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	
	//Objects
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
		
	}
	public void enterProductIntoSearchBoxField(String productName) {
		searchBoxField.sendKeys(productName);
		
		
	}
	
	public SearchResultPage searchForAProduct(String productName) {
		searchBoxField.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage(driver);
		
	}
	
	public void clickOnMyAccountDropMenu() {
		myAccountDropDown.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropDown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(driver);
		
	}

}
