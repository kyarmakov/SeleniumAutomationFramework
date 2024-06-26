package tests.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.DataProviderUtils;
import utils.RandomUtils;

import java.util.Map;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    void registrationTest(Map<String, String> map) {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();
        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        String password = RandomUtils.getRandomPassword();
        AccountCreatedPage accountCreatedPage = registerPage
                .enterFirstName(map.get("firstName"))
                .enterLastName(map.get("lastName"))
                .enterEmail(map.get("email"))
                .enterTelephone(map.get("telephone"))
                .enterPassword(map.get("password"))
                .enterConfirmPassword(map.get("confirmPassword"))
                .clickOnPrivacyPolicy()
                .clickOnContinueButton();

        Assert.assertEquals(accountCreatedPage.getTitle(), "Your Account Has Been Created!");
    }
}
