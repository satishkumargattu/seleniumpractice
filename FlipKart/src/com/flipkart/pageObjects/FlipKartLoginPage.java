package com.flipkart.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.flipkart.accelarators.ActionDriver;
import com.flipkart.utilities.MyOwnException;
import com.flipkart.utilities.Report;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class FlipKartLoginPage extends FlipKartCommonPage {

	private static final Logger log = LogManager.getLogger(FlipKartLoginPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public FlipKartLoginPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================
	
	@FindBy(how = How.LINK_TEXT, using = "Login & Signup")
	public WebElement logInSignUpButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")	
	public WebElement username;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")	
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")	
	public WebElement loginButton;
	
	// ===================== PAGE METHODS ======================

	public void login(String divorinternal, ExtentTest test) throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			
			Thread.sleep(5000);
			
			//MyWebElement.clickOn(logInSignUpButton);
			
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, username);
			
			
				MyWebElement.enterText(username, "9849530029");				
				MyWebElement.enterText(password, "satish@123");
							
				
				ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
						+ testRunTimeStamp + "\\1_HelahChoiceLogin_Screen.png");
				Report.logTestCaseStatusWithSnapShot(test, "INFO", "Login To Health Choice is initiated successfully",
						System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\" + "1_HelahChoiceLogin_Screen.png");
			
				loginButton.click();
				
				
			Thread.sleep(5000);
			
						
	//		Assert.assertEquals(flipKartspages.HomePage().mobileLink.getText(), "Mobiles & Tablets");
			
			// LogInformation for this login method
			//Report.logTestCaseStatus(test, "INFO", "Login To Health Choice is initiated successfully");
			
			

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
