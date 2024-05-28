package constants;

public final class FrameworkConstants {
    private static final String CONFIGJSONFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.json";

    private FrameworkConstants() {}

    public static String getConfigJsonFilePath() {
        return CONFIGJSONFILEPATH;
    }
}
