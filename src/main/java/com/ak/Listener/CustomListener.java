package com.ak.Listener;

import java.io.FileNotFoundException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ak.base.BaseTest;
import com.ak.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomListener extends BaseTest implements ITestListener{
	
	static Date d = new Date();
	static String filename = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	public static ExtentReports report = ExtentManager.getInstance(filename);
	public static ExtentTest test;

	public CustomListener() throws FileNotFoundException {
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String msg = methodName +" Passed successfully";
		
		Markup m = MarkupHelper.createLabel(msg, ExtentColor.GREEN);
		test.log(Status.PASS, m);
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		String exceptionMsg = result.getThrowable().getStackTrace().toString();
		test.fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception Occured: Click to see the details"+"</font>"
		           +"</b>"+"</summary>"+exceptionMsg+"</details>");
		
		String methodName = result.getMethod().getMethodName();
		String msg = methodName +" is Skipped";
		
		Markup m = MarkupHelper.createLabel(msg, ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
		
	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String msg = methodName +" is Skipped";
		
		Markup m = MarkupHelper.createLabel(msg, ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
