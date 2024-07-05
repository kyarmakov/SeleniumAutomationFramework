package pages;

import constants.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentReportLogger;

import java.time.Duration;

public class BasePage {
    WebElement find(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
        return wait.until(d -> d.findElement(by));
    }

    void click(By by) {
        WebElement webElement = find(by);
        String accessibleName = webElement.getAccessibleName();
        webElement.click();
        ExtentReportLogger.info(accessibleName + " is clicked");
    }

    void click(By by, String elementName) {
        find(by).click();
        ExtentReportLogger.info(elementName + " is clicked");
    }

    void type(By by, String value) {
        WebElement webElement = find(by);
        String accessibleName = webElement.getAccessibleName();
        webElement.sendKeys(value);
        ExtentReportLogger.info(value + " is entered to " + accessibleName);
    }

    void hoverOn(By by) {
        WebElement webElement = find(by);
        String accessibleName = webElement.getAccessibleName();
//        Actions actions = new Actions(DriverManager.getDriver());
//        actions.moveToElement(webElement).perform();
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", webElement);
        ExtentReportLogger.info(accessibleName + " is hovered upon");
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
