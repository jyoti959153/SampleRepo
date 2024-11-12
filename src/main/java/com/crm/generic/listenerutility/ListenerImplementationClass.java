package com.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener,ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		
	System.out.println("report backup");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {//here we are getting runtimeevent(failure) in result
		String bug=result.getMethod().getMethodName();//getting testcasename which is getting fail
		String localTime = new Date().toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot ts=(TakesScreenshot) BaseClass.BaseTest.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File per=new File("./Screenshot/"+bug+""+localTime+""+".png");
		try {
			FileUtils.copyFile(temp, per);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
