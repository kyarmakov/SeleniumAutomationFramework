package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.RandomUtils;

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
        String randomEmail = RandomUtils.getRandomEmail();

        String[] values = {
                "John",
                "Doe",
                randomEmail,
                "1234567890",
                "qwerty123456",
                "qwerty123456"
        };

        AccountCreatedPage accountCreatedPage = registerPage.enterValues(values).clickOnPrivacyPolicy().clickOnContinueButton();

        Assert.assertEquals(accountCreatedPage.getTitle(), "Your Account Has Been Created!");
        context.getSuite().setAttribute("randomEmail", randomEmail);
    }
}
