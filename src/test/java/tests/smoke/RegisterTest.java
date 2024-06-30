package tests.smoke;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.RandomUtils;

import java.util.*;

public class RegisterTest extends BaseTest {
    @Test(dataProvider = "registrationTestDataProvider")
    void registerTest(ITestContext context, Map<String, String> map) {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();
        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        context.getSuite().setAttribute("email", map.get("email"));
        context.getSuite().setAttribute("password", map.get("password"));

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

    @DataProvider
    private Iterator<Map<String, String>> registrationTestDataProvider() {
        String randomEmail = RandomUtils.getRandomEmail();
        String randomPassword = RandomUtils.getRandomPassword();

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("firstName", "John");
        map.put("lastName", "Doe");
        map.put("email", randomEmail);
        map.put("telephone", "1234567890");
        map.put("password", randomPassword);
        map.put("confirmPassword", randomPassword);

        list.add(map);

        return list.iterator();
    }
}
