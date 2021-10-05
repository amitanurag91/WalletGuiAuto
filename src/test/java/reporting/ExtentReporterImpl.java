package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ExtentReporterImpl {
    public static ExtentReports report = new ExtentReports();
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static String reportPath = System.getProperty("user.dir")
            + "\\ExtentReports\\report.html";

    //public static String reportPath = "extentReport.html";


    public static void createReport() {
        spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Mobile Wallet Automation Report");
        spark.config().setReportName("Automation report");
        report.attachReporter(spark);
    }

    public static void logTestToReport(ITestResult t, String testMethod) {
        ExtentTest test = report.createTest(testMethod);
        if (t.getStatus() == ITestResult.SUCCESS) {
            test.pass(testMethod + " passed successfully");
        } else if (t.getStatus() == ITestResult.FAILURE) {
            test.fail(testMethod + " failed");
        } else if (t.getStatus() == ITestResult.SKIP) {
            test.skip(testMethod + " was skipped");
        }


    }

    public static ExtentTest createTestInReport(String testMethod)
    {
        ExtentTest test = report.createTest(testMethod);
        return  test;
    }

    public static  void logResultToReport(ITestResult t,String testMethod,ExtentTest test)
    {

        if (t.getStatus() == ITestResult.SUCCESS) {
            test.pass(testMethod + " passed successfully");
        } else if (t.getStatus() == ITestResult.FAILURE) {
            test.fail(testMethod + " failed");
        } else if (t.getStatus() == ITestResult.SKIP) {
            test.skip(testMethod + " was skipped");
        }

    }

    public static void finalizeReport() {
        report.flush();
    }

    @BeforeClass
    public void setupReporter() {
        ExtentReporterImpl.createReport();
    }

    @AfterClass
    public void flushReport() {
        ExtentReporterImpl.finalizeReport();
    }




}





