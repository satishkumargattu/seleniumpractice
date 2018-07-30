package com.flipkart.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import com.flipkart.accelarators.ActionDriver;
import com.flipkart.accelarators.Base;
import com.flipkart.utilities.MyOwnException;
import com.flipkart.utilities.Report;

public class FlipKartWorkFlow extends Base {

	private static final Logger log = LogManager.getLogger(FlipKartWorkFlow.class.getName());

	public void FlipKart_Login() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			flipKartspages.LoginPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("IUUrl"));
			flipKartspages.LoginPage().login("IUSystem", parentTestCase);

			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	
	
	public void FlipKart_Login_MultipleBrowser(String browserType) throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			flipKartspages.LoginPage().initiateMultipleBrowser(browserType);
			driver.navigate().to(configProps.getProperty("IUUrl"));
			flipKartspages.LoginPage().login("IUSystem", parentTestCase);

			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}


	
	public void SelectMobile() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			
			flipKartspages.HomePage().SelectMobile("IUSystem", parentTestCase);
			
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	
	
	
	public void MobileSelection() throws MyOwnException{
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			
			flipKartspages.HomePage().MobileSelection("IUSystem", parentTestCase);
			
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	
	
	
	public void Tooltip() throws MyOwnException{
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			
			flipKartspages.HomePage().Tooltip("IUSystem", parentTestCase);
			
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	
	
	

	public void AddToCart() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			
			flipKartspages.KartPage().AddToCart("IUSystem", parentTestCase);
			
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	
	public void PlaceOrder() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			// initiation of first child test case
			// childTestCase1 = Report.appendChildTestCase(parentTestCase,
			// "IU_TC1");
			
			flipKartspages.KartPage().PlaceOrder("IUSystem", parentTestCase);
			
			ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
					+ testRunTimeStamp + "\\" + "2_HealthChoiceHomePage.png");
			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Successfully logged into Health Choice",
					System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp + "\\"
							+ "2_HealthChoiceHomePage.png");

		} catch (Exception exp) {
			// failedTestCase = parentTestCase;
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>IU Is Not logged in Successfully</b></font><br />" + exp.getMessage()
							+ "<br />");
			throwException("UNABLE TO INITIATE THE login PROCESS \n" + exp.getMessage() + "\n");
		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

}
