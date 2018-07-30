package com.flipkart.testScripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.flipkart.accelarators.ActionDriver;
import com.flipkart.pageObjects.FlipKartWorkFlow;
import com.flipkart.utilities.DataProviderRepository;
import com.flipkart.utilities.MyOwnException;
import com.flipkart.utilities.Report;

public class FlipKartTestCase extends FlipKartWorkFlow {

	private static final Logger log = LogManager.getLogger(FlipKartTestCase.class.getName());

	@Test(dataProvider = "FlipKartTestData", dataProviderClass = DataProviderRepository.class)
	public void FlipKart_TC1(String Login)
			throws InterruptedException, MyOwnException {

		log.info("METHOD(IU_TC1) EXECUTION STARTED SUCCESSFULLY");
		try {
			
			RetrievingMapData(Login);

			// initiation of parent test case scenario based
			parentTestCase = Report.makeTestCaseEntry(report, "HealthChoice_Testing");
			Report.assignCategoryToTestCase(parentTestCase, "TC1");
			
			FlipKart_Login();	
			SelectMobile();
		//	MobileSelection();
			
			
			AddToCart();
		    PlaceOrder();

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("Login SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("METHOD(IU_TC1) EXECUTED SUCCESSFULLY");
	}
	


	@AfterMethod(alwaysRun = true)
	public void afterExecutionOfEachTest(Method method, ITestContext ctx, ITestResult status)
			throws InterruptedException, IOException, MyOwnException {
		
		log.info("AFTER METHOD EXECUTION STARTED SUCCESSFULLY");
		try {
			
			if (ITestResult.SUCCESS == status.getStatus()) {
				/*Report.logTestCaseStatus(parentTestCase, "PASS",
						"IU_TC1 Is Successful");*/

			} else if (ITestResult.FAILURE == status.getStatus()) {
				ActionDriver.screenShot(System.getProperty("user.dir") + configProps.getProperty("results") + "_"
						+ testRunTimeStamp + "\\" + "1_Login Failed.png");
				Report.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
						"Listing Process And IPO Process Is Not Successful",
						System.getProperty("user.dir") + configProps.getProperty("results") + "_" + testRunTimeStamp
						+ "\\" + "1_Login Failed.png");
			} else if (ITestResult.SKIP == status.getStatus()) {
				Report.logTestCaseStatus(parentTestCase, "SKIP", "Test Case Is Skipped");
			}
			Report.writeContents(report);
			
			//driver.quit();
			
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Report.logTestCaseStatus(parentTestCase, "FAIL",
					"<font color=red><b>After Method Is Not Successful</b></font><br />" + exp.getMessage() + "<br />");
			throwException("AFTER METHOD IS NOT SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("AFTER METHOD EXECUTED SUCCESSFULLY");
	}

	private void RetrievingMapData(String IULogin) throws MyOwnException {
		
		log.info("METHOD(RetrievingMapData) EXECUTION STARTED SUCCESSFULLY");
		try {
			if (!IULogin.isEmpty()) {
				IULoginMap = ActionDriver.splitToMap(IULogin);
			}
		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("UNABLE TO FORM MAPS WITH THE TEST DATA RETRIEVED FROM FROM THE GIVEN STRINGS PARAMETERS\n"
					+ exp.getMessage() + "\n");
		}
		log.info("METHOD(RetrievingMapData) EXECUTED SUCCESSFULLY");
	}

}
