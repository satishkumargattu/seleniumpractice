package com.flipkart.pageObjects;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import com.flipkart.accelarators.ActionDriver;
import com.flipkart.utilities.MyOwnException;
import com.flipkart.utilities.Report;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class FlipKartGotoCartPage extends FlipKartCommonPage {

	private static final Logger log = LogManager.getLogger(FlipKartGotoCartPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public FlipKartGotoCartPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================
	
		
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button")
	public WebElement addCartButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='container']/div/div[1]/div/div[1]/div/div[3]/div/div/form/button")
	public WebElement PlaceOrder;
	@FindBy(how=How.XPATH,using="//*[@id='CNTCT61A0C9AAA391410691F10FC6E']/button")
	public WebElement PlaceAddress;

	@FindBy(how=How.XPATH,using="//*[@id='to-payment']/button")
	public WebElement AddressContinue;
	
	@FindBy(how=How.ID ,using="CREDIT")//*[@id='container']/div/div[1]/div/div[1]/div[4]/div/div/div[1]/div/label[2]/div[1]")//*[@id="CREDIT"]
	public WebElement PaymetRadio;
	
	
	public void AddToCart(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			
			String winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			MyWebElement.clickOn(addCartButton);
			
			
				
			driver.switchTo().window(winHandleBefore);
						
			
		} 
		catch (AssertionError exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL", "<font color=red><b>Login To ePortal Is Not Successful</b></font><br />"
					+ exp.getMessage() + "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL", "<font color=red><b>Login To ePortal Is Not Successful</b></font><br />"
					+ exp.getMessage() + "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}	
	
	
	public void PlaceOrder(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			
			String winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			MyWebElement.clickOn(PlaceOrder);
			
			MyWebElement.clickOn(PlaceAddress);
			
			MyWebElement.clickOn(AddressContinue);
			
			MyWebElement.clickOn(PaymetRadio);
		//	driver.switchTo().window(winHandleBefore);
						
			
		} 
		catch (AssertionError exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL", "<font color=red><b>Login To ePortal Is Not Successful</b></font><br />"
					+ exp.getMessage() + "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL", "<font color=red><b>Login To ePortal Is Not Successful</b></font><br />"
					+ exp.getMessage() + "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}	
	

}
