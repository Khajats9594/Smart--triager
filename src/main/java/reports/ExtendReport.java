package reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import enums.CategoryType;

public final class ExtendReport {

	private ExtendReport() {
	}

	private static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
			spark.viewConfigurer()
			     .viewOrder()
				 .as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			extent.attachReporter(spark);
			spark.config().setDocumentTitle("selenium");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("Smart triager");
			extent.setSystemInfo("Operating System", "Macos");
			extent.setSystemInfo("browser", "chrome");
			extent.setSystemInfo("java version", "java 18");

		}

	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
	}
	
	public static void createTest(String testcasename) {
		test = extent.createTest(testcasename);
	}
	
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtendReport.test.assignAuthor(temp);
		}
	}
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtendReport.test.assignCategory(temp.toString());
		}
	}
}
