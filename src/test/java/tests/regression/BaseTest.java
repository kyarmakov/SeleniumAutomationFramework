package tests.regression;

import driver.Driver;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BaseTest() {}

    @BeforeMethod
    protected void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
