package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
		//homePage.clickOnMyAccountDropMenu();
		//registerPage=homePage.selectRegisterOption();
		
		registerPage=homePage.navigateToRegisterPage();
		
		/*driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();*/
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterAccountWithMandatoryFields() {
		
		/*registerPage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerPage.enterLastNameField(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyBox();
		accountSuccessPage=registerPage.clickOnContinueButton();*/
		
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
		
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		
		
		String actualSuccessHeading=accountSuccessPage.retreiveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Success Page is not Displayed");
		
				
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisterAccountWithAllFields() {
		
		
		/*registerPage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerPage.enterLastNameField(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickOnYesNewsLetterButton();
		registerPage.selectPrivacyPolicyBox();
		accountSuccessPage=registerPage.clickOnContinueButton();*/
		
		accountSuccessPage=registerPage.registerAccountWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
		
		
		String actualSuccessHeading=accountSuccessPage.retreiveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not Displayed");
	
		
	}
	
	@Test(priority=3)
	public void verifyRegisterAccountByProvidingExistingEmailAddress()  {
		
		
		/*registerPage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerPage.enterLastNameField(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickOnYesNewsLetterButton();
		registerPage.selectPrivacyPolicyBox();
		registerPage.clickOnContinueButton();*/
		
		
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
		
		accountSuccessPage=registerPage.registerAccountWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		
		String actualWarning=registerPage.retreiveduplicateEmailAddressWarning();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")) ,"Warning Message is not Displayed");
		
	}
	
	@Test(priority=4)
	public void verifyRegisterAccoutnWithoutProvidingAnyDetails() {
		
		
	   registerPage.clickOnContinueButton();
		
		
		
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		
		
		String actualPrivacyPolicyWarning=registerPage.retreivePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning Message is not Displayed");
		
		String actualFirstNameWarning=registerPage.retreiveFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")),"FirstName Warning is not Displayed");
		
		
		String actualLastNameWarning=registerPage.retreiveLastNameWarning();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")),"LastName Warning is not Displayed");
		
		String actualEmailWarning=registerPage.retreiveEmailWarning();
		Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailAddressWarning")),"E-Mail Warning is not Displayed");
		
		String actualTelephoneWarning=registerPage.retreiveTelephonewarning();
		Assert.assertTrue(actualTelephoneWarning.contains(dataProp.getProperty("telephoneWarning")),"Telephone Warning is not Displayed");
		
		String actualPasswordWarning=registerPage.retreivePasswordWarning();
		Assert.assertTrue(actualPasswordWarning.contains(dataProp.getProperty("passwordWarning")),"Password Warning is not Displayed");
		
	}
	
	

}
