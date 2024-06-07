package reports;

public final class ExtentReportLogger {
    private ExtentReportLogger() {}

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }
}
