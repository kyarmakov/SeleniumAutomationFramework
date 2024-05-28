package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    static WebDriver getDriver() {
        return driver.get();
    }

    static void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    static void unload() {
        driver.remove();
    }
}