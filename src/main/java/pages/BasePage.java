package pages;

import constants.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebElement find(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
        return wait.until(d -> d.findElement(by));
    }

    void click(By by) {
        find(by).click();
    }

    void type(By by, String value) {
        find(by).sendKeys(value);
    }

    void hoverOn(By by) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(find(by)).perform();
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
