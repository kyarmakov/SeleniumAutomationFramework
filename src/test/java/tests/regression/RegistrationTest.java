package tests.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.RandomUtils;

public class RegistrationTest extends BaseTest {

    @Test
    void registrationTest() {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();
        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        String password = RandomUtils.getRandomPassword();
        AccountCreatedPage accountCreatedPage = registerPage
                .enterFirstName("Jane")
                .enterLastName("Doe")
                .enterEmail(RandomUtils.getRandomEmail())
                .enterTelephone("1234567890")
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickOnPrivacyPolicy()
                .clickOnContinueButton();

        Assert.assertEquals(accountCreatedPage.getTitle(), "Your Account Has Been Created!");
    }
}
