import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int count = 0;
    private static int maxTry = 2;
 
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                     
            if (count < maxTry) {                            
                count++;                                  
            
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
             
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
    
    @AfterMethod(enabled=false)
    public void afterMethod(ITestResult result) {
        IRetryAnalyzer retry = result.getMethod().getRetryAnalyzer();
        if (retry == null) {
            return;
        }
        result.getTestContext().getFailedTests().removeResult(result.getMethod());
        result.getTestContext().getSkippedTests().removeResult(result.getMethod());
    }
 
}

