package driver;

import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.JsonUtils;

import java.util.Objects;

public final class Driver {


    private Driver() {}

    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
