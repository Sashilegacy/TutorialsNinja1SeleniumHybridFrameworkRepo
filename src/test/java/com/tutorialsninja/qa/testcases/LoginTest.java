package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.utils.Utilities;

public class LoginTest extends Base{
	public WebDriver driver;
	LoginPage loginPage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		//homePage.clickOnMyAccountDropMenu();
		//loginPage=homePage.selectLoginOption();
		loginPage=homePage.navigateToLoginPage();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="validCredentialSupplier")
	public void verifyLoginWithValidCred(String email,String password) {
		
		
		//loginPage.enterEmailAddress(email);
		//loginPage.enterPassword(password);
		AccountPage accountPage = loginPage.navigateToAccountPage(email, password);
		
		//AccountPage accountPage = loginPage.clickOnLoginButton();
		
		
		/*driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();*/
		
		
		
		driver.findElement(By.xpath("//a[text()='Change your password']")).getText();
		
		Assert.assertTrue(accountPage.getDisplayStatusOfChangeYourPasswordOption(),"Change Your Password Option is not Displayed");
		driver.quit();
		
		}
	
	@DataProvider(name="validCredentialSupplier")
	public Object[][]supplyTestData() {
		Object[][]data=Utilities.getTestDataFromExcel("Login");
		
		return data;
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCred()  {
		
		
		/*loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();*/
		loginPage.navigateToAccountPage(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		 
		/*driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();*/
		
		
		String actualWarningMessage=loginPage.retreiveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
		
		
		
		
	}
	
	
	
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()  {
		
		
		/*loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();*/
		
		
		/*driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();*/
		
		loginPage.navigateToAccountPage(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		String actualWarningMessage=loginPage.retreiveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
		
		
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInalidPassword() {
		
		/*loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();*/
		
		/*driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();*/
		
		loginPage.navigateToAccountPage(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		String actualWarningMessage=loginPage.retreiveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
		
	
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCred() {
		
		loginPage.clickOnLoginButton();
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage=loginPage.retreiveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
		}
	
	
	
	
}
