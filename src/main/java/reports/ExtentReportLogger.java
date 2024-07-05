package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentReportLogger {
    private ExtentReportLogger() {}

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
    }

    public static void info(String message) {
        ExtentReportManager.getExtentTest().info(message);
    }

    private static String getBase64Screenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
