package constants;

public final class FrameworkConstants {
    private static final String CONFIGJSONFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.json";
    private static final int EXPLICITWAIT = 10;
    private static final String SMOKESUITESEARCHPRODUCT = "iphone";

    private FrameworkConstants() {}

    public static String getConfigJsonFilePath() {
        return CONFIGJSONFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getSmokeSuiteSearchProduct() {
        return SMOKESUITESEARCHPRODUCT;
    }
}
