package vaibhav.framework.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import vaibhav.framework.base.PredefinedActions;

public class TestBase {

	@BeforeMethod
	public void setUp() {
		System.out.println("STEP - Open Browser");
		PredefinedActions.start();
	}
	@AfterMethod()
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getName();
			PredefinedActions.getScreenShot(methodName);
		}
		System.out.println("STEP- Close Browser");
		PredefinedActions.close();		
	}
}
