package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.xpath("//input[@name='firstname']");

    public void enterValue(String value) {
        type(firstNameInput, value);
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
