package smoke;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class Login_AddToCart_Checkout_LogoutTest extends BaseTest {
    @Test(priority = 1)
    void performLoginTest(ITestContext context) {
        MyAccountPage myAccountPage = performLogin(context);

        Assert.assertEquals(myAccountPage.getTitle(), "My Account");
    }

    private MyAccountPage performLogin(ITestContext context) {
        String email = (String) context.getSuite().getAttribute("email");
        String password = (String) context.getSuite().getAttribute("password");

        LoginPage loginPage = new HomePage().clickOnLoginLink();
        return loginPage.enterValues(email, password).clickOnLoginButton();
    }
}
