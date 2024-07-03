package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;
import reports.ExtentReportLogger;

import java.io.IOException;
import java.util.Arrays;

public class ReportListener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String suite = result.getTestClass().toString().split("tests\\.")[1].split("\\.")[0];
        ExtentReport.createTest(suite.toUpperCase() + " - " + result.getMethod().getMethodName() + " - " + result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportLogger.fail(result.getMethod().getMethodName() + " is failed");
        ExtentReportLogger.fail(result.getThrowable().toString());
        ExtentReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()).replace(",", "<br/>"));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }
}
