package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import driver.DriverManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extent;
    private static String path;

    private ExtentReport() {}

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            path = FrameworkConstants.getExtentReportPath();
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Lambda Test Playground");
        }
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent))
            extent.flush();

        ExtentReportManager.unload();
//        Desktop.getDesktop().browse(new File(path).toURI());
    }

    public static void createTest(String testcaseName) {
        ExtentReportManager.setExtentTest(extent.createTest(testcaseName));
    }
}
