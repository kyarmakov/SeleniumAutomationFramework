package tests;

import driver.Driver;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected BaseTest() {}

    @BeforeSuite
    protected void setup() {
        Driver.initDriver();
    }

    @AfterSuite
    protected void tearDown() {
//        Driver.quitDriver();
    }
}
