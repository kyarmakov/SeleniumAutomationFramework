package pages;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {
    private final By myAccountDropdown = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a");
    private final By registerLink = By.xpath("//span[contains(text(), 'Register')]/ancestor::a");
    private final By loginLink = By.xpath("//span[contains(text(), 'Login')]/ancestor::a");

    public RegisterPage clickOnRegisterLink() {
        hoverOn(myAccountDropdown);
        click(registerLink);
        return new RegisterPage();
    }

    public LoginPage clickOnLoginLink() {
        hoverOn(myAccountDropdown);
        click(loginLink);
        return new LoginPage();
    }
}