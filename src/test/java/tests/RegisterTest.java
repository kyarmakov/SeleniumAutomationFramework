package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test(priority = 2)
    void getRegisterPageTest(ITestContext context) {
        RegisterPage registerPage = new HomePage().clickOnRegisterLink();

        Assert.assertEquals(registerPage.getTitle(), "Register Account");

        context.setAttribute("registerPage", registerPage);
    }

    @Test(priority = 2)
    void performRegistrationTest(ITestContext context) {
        RegisterPage registerPage = (RegisterPage) context.getAttribute("registerPage");
        registerPage.enterValue("John");
    }
}
