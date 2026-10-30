package com.qa.opencart.Listeners1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{

	private int count = 0;
    private static int maxTry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()) { // Check if test did not succeed
            if (count < maxTry) { // Check if max retry count is reached
                count++; // Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed
                return true; // Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE); // If maxCount reached, test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
        }

        return false;
    }
	
}
