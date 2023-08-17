package listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import annotation.FrameworkAnnotation;
import enums.LogType;
import reports.ExtendReport;
import reports.FrameworkeLogger;

public class Listener implements ITestListener, ISuiteListener {

	private Map<String, List<ITestResult>> exceptionGroup = new HashMap<>();

	@Override
	public void onStart(ISuite suite) {
		
		ExtendReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		
		ExtendReport.createTest("Failed Test Cases Summary");
		FrameworkeLogger.log(LogType.FAIL, createExceptionGroupsTable(exceptionGroup));
		ExtendReport.flushReports();

	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtendReport.createTest(result.getMethod()
									  .getMethodName());
		
		ExtendReport.addAuthors(result.getMethod()
				                      .getConstructorOrMethod()
				                      .getMethod()
				                      .getAnnotation(FrameworkAnnotation.class)
				                      .author());
		
		ExtendReport.addCategories(result.getMethod()
				                         .getConstructorOrMethod()
				                         .getMethod()
				                         .getAnnotation(FrameworkAnnotation.class)
				                         .category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		FrameworkeLogger.log(LogType.PASS, result.getMethod().getMethodName() + " is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		FrameworkeLogger.log(LogType.FAIL, result.getMethod()
				                                 .getMethodName() + " is failed");
		
		FrameworkeLogger.log(LogType.FAIL, result.getThrowable()
				                                 .toString());
		
		//FrameworkeLogger.log(LogType.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
		FrameworkeLogger.log(LogType.FAIL, "<pre>"+getStackTraceAsString(result.getThrowable().getStackTrace())+"</pre>");
		
		
		String exceptionType = result.getThrowable()
				                     .getClass()
				                     .getName();
		
		List<ITestResult> listResult = exceptionGroup.computeIfAbsent(exceptionType, k -> new ArrayList<>());
		listResult.add(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		FrameworkeLogger.log(LogType.SKIP, result.getMethod()
				                                 .getMethodName() + " is skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special
		 * implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {

	}

	private String createExceptionGroupsTable(Map<String, List<ITestResult>> exceptionGroups) {

		StringBuilder tableHtml = new StringBuilder();
		tableHtml.append("<table border='1' style='border-collapse: collapse;'>");
		tableHtml.append("<tr><th>Exception</th><th>Failed Test Cases</th></tr>");

		for (Map.Entry<String, List<ITestResult>> entry : exceptionGroups.entrySet()) {
			tableHtml.append("<tr><td>")
			         .append(entry.getKey()).append("</td><td>")
					 .append(getFailedTestCases(entry.getValue())).append("</td></tr>");
		}

		tableHtml.append("</table>");
		return tableHtml.toString();
	}

	private String getFailedTestCases(List<ITestResult> results) {
		
		StringBuilder testCases = new StringBuilder();
		for (ITestResult result : results) {
			testCases.append(result.getMethod()
					               .getMethodName())
			                       .append("<br>");
		}
		return testCases.toString();
	}
	
	private String getStackTraceAsString(StackTraceElement[] stackTrace) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : stackTrace) {
            sb.append("\n").append(element.toString());
        }
        return sb.toString();
    }

}
