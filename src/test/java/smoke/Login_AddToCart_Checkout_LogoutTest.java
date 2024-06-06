package smoke;

import constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductsListPage;

public class Login_AddToCart_Checkout_LogoutTest extends BaseTest {
    @Test(priority = 1)
    void performLoginTest(ITestContext context) {
        MyAccountPage myAccountPage = performLogin(context);

        Assert.assertEquals(myAccountPage.getTitle(), "My Account");
    }

    @Test(priority = 2)
    void addToCartTest(ITestContext context) {
        MyAccountPage myAccountPage = performLogin(context);

        ProductsListPage productsListPage = myAccountPage.searchFor(FrameworkConstants.getSmokeSuiteSearchProduct());
        String productPageTitle = "Search - " + FrameworkConstants.getSmokeSuiteSearchProduct();

        Assert.assertEquals(productsListPage.getTitle(), productPageTitle);
    }

    private MyAccountPage performLogin(ITestContext context) {
        String email = (String) context.getSuite().getAttribute("email");
        String password = (String) context.getSuite().getAttribute("password");

        LoginPage loginPage = new HomePage().clickOnLoginLink();
        return loginPage.enterValues(email, password).clickOnLoginButton();
    }
}
