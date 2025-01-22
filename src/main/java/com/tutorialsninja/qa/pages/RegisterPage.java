package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	//Constructor
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement yesToNewsLetter;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyRadioButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement duplicateEmailAddressWarning;
	 
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	//Action Methods
	public String retreivePasswordWarning() {
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	public String retreiveTelephonewarning() {
		String telephoneWarningText=telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retreiveEmailWarning() {
		String emailWarningText=emailWarning.getText();
		return emailWarningText;
	}
	public String retreiveLastNameWarning() {
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retreiveFirstNameWarning() {
		String firstNameWarningText=firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	
	public String retreivePrivacyPolicyWarning() {
		String privacyPolicyWarningText=privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String retreiveduplicateEmailAddressWarning() {
		String duplicateEmaailWarningText=duplicateEmailAddressWarning.getText();
		return duplicateEmaailWarningText;
	}
	
	public void enterFirstNameField(String fNameText) {
		firstNameField.sendKeys(fNameText);
	}
	
	public void enterLastNameField(String lNameText) {
		lastNameField.sendKeys(lNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	
	public void enterTelephoneNumber(String telephoneNumber) {
		telephoneField.sendKeys(telephoneNumber);
		
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		confirmPasswordField.sendKeys(passwordText);
	}
	
	public void clickOnYesNewsLetterButton() {
		yesToNewsLetter.click();
	}
	
	public void selectPrivacyPolicyBox() {
		privacyPolicyRadioButton.click();
	}
	
	
	public AccountSuccessPage clickOnContinueButton() {
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	public AccountSuccessPage registerWithMandatoryFields(String fNameText,String lNameText,String emailText,String telephoneNumber,String passwordText) {
		firstNameField.sendKeys(fNameText);
		lastNameField.sendKeys(lNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneNumber);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		privacyPolicyRadioButton.click();
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerAccountWithAllFields(String fNameText,String lNameText,String emailText,String telephoneNumber,String passwordText) {
		firstNameField.sendKeys(fNameText);
		lastNameField.sendKeys(lNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneNumber);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		yesToNewsLetter.click();
		privacyPolicyRadioButton.click();
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	

}
