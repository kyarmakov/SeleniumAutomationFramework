package tests.regression;

import driver.Driver;
import driver.DriverManager;
import org.testng.ITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.Map;

public class BaseTest implements ITest {
    private ThreadLocal<String> testName = new ThreadLocal<>();
    public BaseTest() {}

    @BeforeMethod
    public void setUp(Object[] data) {
        Map<String, String> test = (Map<String, String>) data[0];
        testName.set(test.get("testName"));
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Override
    public String getTestName() {
        return testName.get();
    }
}
