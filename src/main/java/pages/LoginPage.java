package pages;

import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginButton = By.xpath("//input[@type='submit' and @value='Login']");

    public LoginPage enterValues(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }

    public MyAccountPage clickOnLoginButton() {
        click(loginButton);
        return new MyAccountPage();
    }
}