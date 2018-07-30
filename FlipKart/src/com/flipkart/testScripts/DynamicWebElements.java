package com.flipkart.testScripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.accelarators.ActionDriver;
import com.flipkart.pageObjects.FlipKartWorkFlow;
import com.flipkart.utilities.DataProviderRepository;
import com.flipkart.utilities.MyOwnException;
import com.flipkart.utilities.Report;

public class DynamicWebElements extends FlipKartWorkFlow {

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
			MobileSelection();
			
			//Tooltip();
			//AddToCart();
			//PlaceOrder();

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("Login SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("METHOD(IU_TC1) EXECUTED SUCCESSFULLY");
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
