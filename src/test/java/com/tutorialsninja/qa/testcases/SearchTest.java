package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchResultPage;

//Updated Comment

public class SearchTest extends Base{
	public WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifysearchWithAValidProduct() {
		
		searchResultPage=homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		//SearchResultPage searchResultPage = homePage.clickOnSearchButton();
		
	    //driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		
		Assert.assertTrue(searchResultPage.displayStatusOfValidHPProduct(),"Valid Search Product is not Displayed");
		
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		searchResultPage=homePage.searchForAProduct(dataProp.getProperty("inValidProduct"));
	
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("inValidProduct"));
		//searchResultPage=homePage.clickOnSearchButton();
		
		
		/*driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("inValidProduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();*/
		
		
		String actualSearchMessage=searchResultPage.retreiveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, "abcd", "No Product in Search Results is Displayed");
		
	}
	
	
	@Test(priority=3,dependsOnMethods= {"verifySearchWithInvalidProduct"})
	public void verifySearchingWithoutAnyProduct() {
		
		searchResultPage=homePage.clickOnSearchButton();
		/*driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();*/
		
		String actualSearchMessage=searchResultPage.retreiveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductInTextSearchResults"), "No Product in Search Results is Displayed");
		
	}

}
