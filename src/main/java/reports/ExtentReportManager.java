package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    private ExtentReportManager() {}

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest extentTestRef) {
        extentTest.set(extentTestRef);
    }

    static void unload() {
        extentTest.remove();
    }
}
