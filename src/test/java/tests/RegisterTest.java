package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test(priority = 1)
    void getRegisterPageTest(ITestContext context) {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();

        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        context.setAttribute("registerPage", registerPage);
    }

    @Test(priority = 2)
    void performRegistrationTest(ITestContext context) {
        RegisterPage registerPage = (RegisterPage) context.getAttribute("registerPage");

        String[] values = {
                "John",
                "Doe",
                "asdf12asdf34asdfaqwe@gmail.com",
                "1234567890",
                "qwerty123456",
                "qwerty123456"
        };

        AccountCreatedPage accountCreatedPage = registerPage.enterValues(values).clickOnPrivacyPolicy().clickOnContinueButton();

        Assert.assertEquals(accountCreatedPage.getTitle(), "Your Account Has Been Created!");
    }
}
