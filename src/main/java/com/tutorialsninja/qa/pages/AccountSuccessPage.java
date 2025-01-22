package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;

	//Constructor
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	//Objects
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccesspageHeading;

	//Action Methods
	public String retreiveAccountSuccessPageHeading () {
		String accountSuccessPageHeadingText=accountSuccesspageHeading.getText();
		return accountSuccessPageHeadingText;
	}
}