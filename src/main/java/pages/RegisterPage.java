package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.xpath("//input[@name='firstname']");
    private final By lastNameInput = By.xpath("//input[@name='lastname']");
    private final By emailInput = By.xpath("//input[@name='email']");
    private final By telephoneInput = By.xpath("//input[@name='telephone']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By confirmPasswordInput = By.xpath("//input[@name='confirm']");
    private final By agreeToPrivacyPolicyInput = By.xpath("//label[@for='input-agree']");
    private final By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    private final By emailAlreadyRegisteredErrorElement = By.xpath("//div[text()=' Warning: E-Mail Address is already registered!']");
    private final By agreeToPrivacyPolicyErrorElement = By.xpath("//div[text()=' Warning: You must agree to the Privacy Policy!']");

    public String getAgreeToPrivacyPolicyErrorMessage() {
        WebElement webElement = find(agreeToPrivacyPolicyErrorElement);
        return webElement.getText();
    }
    public String getEmailAlreadyRegisteredErrorMessage() {
        WebElement webElement = find(emailAlreadyRegisteredErrorElement);
        return webElement.getText();
    }
    public RegisterPage enterConfirmPassword(String value) {
        type(confirmPasswordInput, value);
        return this;
    }
    public RegisterPage enterPassword(String value) {
        type(passwordInput, value);
        return this;
    }
    public RegisterPage enterTelephone(String value) {
        type(telephoneInput, value);
        return this;
    }
    public RegisterPage enterEmail(String value) {
        type(emailInput, value);
        return this;
    }
    public RegisterPage enterLastName(String value) {
        type(lastNameInput, value);
        return this;
    }
    public RegisterPage enterFirstName(String value) {
        type(firstNameInput, value);
        return this;
    }
    public RegisterPage clickOnPrivacyPolicy(boolean toClick) {
        if (toClick)
            click(agreeToPrivacyPolicyInput, "Privacy Policy");

        return this;
    }

    public RegisterPage clickOnPrivacyPolicy() {
        click(agreeToPrivacyPolicyInput, "Privacy Policy");
        return this;
    }

    public AccountCreatedPage clickOnContinueButton() {
        click(continueButton);
        return new AccountCreatedPage();
    }

    public String getActualErrorMessage(String expectedErrorMessage) {
        String xpathTemplate = "//*[text()='%s']";
        System.out.println("STRING FORMATTED: " + String.format(xpathTemplate, expectedErrorMessage));
        By by = By.xpath(String.format(xpathTemplate, expectedErrorMessage));
        WebElement webElement = find(by);
        System.out.println("ACTUAL ERROR MESSAGE: " + webElement.getText());
        return webElement.getText();
    }
}
