package constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FrameworkConstants {
    private static final String CONFIGJSONFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.json";
    private static final int EXPLICITWAIT = 10;
    private static final String SMOKESUITESEARCHPRODUCT = "iphone";
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/reports";
    private static final String EXCELPATH = System.getProperty("user.dir") + "/src/test/resources/excel/regression.xlsx";

    private FrameworkConstants() {}

    public static String getExcelPath() {
        return EXCELPATH;
    }

    public static String getConfigJsonFilePath() {
        return CONFIGJSONFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getSmokeSuiteSearchProduct() {
        return SMOKESUITESEARCHPRODUCT;
    }

    public static String getExtentReportPath() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport_" + formattedDateTime + ".html";
        return EXTENTREPORTPATH + "/" + reportName;
    }
}
