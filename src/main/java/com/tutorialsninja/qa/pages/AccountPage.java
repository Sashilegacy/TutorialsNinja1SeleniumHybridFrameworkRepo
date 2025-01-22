package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	 WebDriver driver;
	
	 //Objects
	 
	@FindBy(xpath="//a[text()='Change your password']")
	private WebElement editYourAccountInformation;
	
	
	//constructors
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	//Action Methods
	
	public boolean getDisplayStatusOfChangeYourPasswordOption() {
		boolean displayStatus=editYourAccountInformation.isDisplayed();
		
		return displayStatus;
	}

}
