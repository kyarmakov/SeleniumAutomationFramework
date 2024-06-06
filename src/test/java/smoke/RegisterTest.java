package smoke;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.RandomUtils;

public class RegisterTest extends BaseTest {
    @Test
    void performRegistrationTest(ITestContext context) {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();
        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        String randomEmail = RandomUtils.getRandomEmail();
        String randomPassword = RandomUtils.getRandomPassword();
        context.getSuite().setAttribute("email", randomEmail);
        context.getSuite().setAttribute("password", randomPassword);

        String[] values = {
                "John",
                "Doe",
                randomEmail,
                "1234567890",
                randomPassword,
                randomPassword
        };

        AccountCreatedPage accountCreatedPage = registerPage.enterValues(values).clickOnPrivacyPolicy().clickOnContinueButton();

        Assert.assertEquals(accountCreatedPage.getTitle(), "Your Account Has Been Created!");
    }
}
