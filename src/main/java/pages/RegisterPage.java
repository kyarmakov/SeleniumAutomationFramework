package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.xpath("//input[@name='firstname']");
    private final By lastNameInput = By.xpath("//input[@name='lastname']");
    private final By emailInput = By.xpath("//input[@name='email']");
    private final By telephoneInput = By.xpath("//input[@name='telephone']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By confirmPasswordInput = By.xpath("//input[@name='confirm']");
    private final By agreeToPrivacyPolicyInput = By.xpath("//label[@for='input-agree']");
    private final By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

    private final By[] inputs = {
            firstNameInput,
            lastNameInput,
            emailInput,
            telephoneInput,
            passwordInput,
            confirmPasswordInput,
            agreeToPrivacyPolicyInput,
            continueButton
    };

    public RegisterPage enterValues(String[] values) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = i; j < values.length; j++) {
                type(inputs[i], values[j]);
                break;
            }
        }
        return this;
    }

    public RegisterPage clickOnPrivacyPolicy() {
        click(agreeToPrivacyPolicyInput);
        return this;
    }

    public AccountCreatedPage clickOnContinueButton() {
        click(continueButton);
        return new AccountCreatedPage();
    }
}
