package analizer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer  
{
int counter=0;
	
	int Retrylimit=2;
	
	public boolean retry(ITestResult result) {
		if(counter<Retrylimit)
		{
			counter++;
			return true;
		}
		return false;
		
	}
}
