package com.flipkart.pageObjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.util.List;

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

public class FlipKartHomePage extends FlipKartCommonPage {

	private static final Logger log = LogManager.getLogger(FlipKartHomePage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public FlipKartHomePage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div[2]/a[1]")
	public WebElement mobileLink;

	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/header/div[3]/ul/li[1]/span")
	public WebElement menuLink;

	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/header/div[3]/ul/li[1]/ul/li/ul/li[1]/ul/li[6]/a")
	public WebElement mobileSelectionOPPO;

	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div[3]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/div/a")
	public WebElement selectOPPOMobile;
	@FindBy(how = How.XPATH, using = "\\div[contains(text(),'_2kSfQ4')]")
	public By Mobiles;

	// ===================== PAGE METHODS ======================

	public void SelectMobile(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {

			// -----Menu Click-----
			MyWait.until(ldriver, "ELEMENT_CLICKABLE", 60, menuLink);
			MyWebElement.clickOn(menuLink);

			MyWait.until(ldriver, "ELEMENT_VISIBLE", 60, mobileSelectionOPPO);
			MyWebElement.clickOn(mobileSelectionOPPO);

		

			Thread.sleep(5000);

		} catch (AssertionError exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}//

	
	public void Tooltip(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {


Actions tool=new Actions(ldriver);

WebElement SelectMobile=driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[3]/div/div/div[1]/div[2]/div/div[1]/div/div[1]"));

			Thread.sleep(5000);
			
			tool.clickAndHold(SelectMobile);
			String tooltiptext=SelectMobile.getAttribute("title");
			System.out.print("Tool tip text :"+tooltiptext);

		} catch (AssertionError exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}//


	
	
	public void MobileSelection(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {

			// -----Menu Click-----


			List<WebElement> mobiles = ldriver.findElements(
					By.xpath("//*[@id='container']/div/div[1]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div/div"));
			System.out.println("size.." + mobiles.size());
			
			String winHandleBefore = driver.getWindowHandle();

			for (int i = 1; i <= mobiles.size(); i++) {
				//MyWait.until(ldriver, "ELEMENT_CLICKABLE", 60, menuLink);
				Thread.sleep(3000);
				ldriver.findElement(
						By.xpath("//*[@id='container']/div/div[1]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div/div["+i+"]")).click();
				// Perform the click operation that opens new window

				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				
				
				
			MyWait.until(ldriver, "ELEMENT_CLICKABLE", 60, ldriver.findElement(
						By.xpath("//*[@id='container']/div/div[1]/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button")));
				Thread.sleep(2000);
				ldriver.findElement(
						By.xpath("//*[@id='container']/div/div[1]/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button")).click();
				
				driver.close();			
			
			
				Thread.sleep(2000);
				driver.switchTo().window(winHandleBefore);

			}


		} catch (AssertionError exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(test, "FAIL",
					"<font color=red><b>Login To ePortal Is Not Successful</b></font><br />" + exp.getMessage()
							+ "<br />");
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\1_Login_failed.png");
			throwException(
					"UNABLE TO LOGIN INTO THE LIMA APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
