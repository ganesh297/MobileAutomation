package TestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count=0;
	int maxCount=3;
	
	@Override
	public boolean retry(ITestResult arg0) {
		
		if(count<maxCount){
			count++;
			return true;
		}
		
		
		return false;
	}

}
