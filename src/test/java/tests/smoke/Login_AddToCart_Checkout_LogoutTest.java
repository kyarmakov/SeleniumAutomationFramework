package tests.smoke;

import constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.*;

public class Login_AddToCart_Checkout_LogoutTest extends BaseTest {
    @Test(suiteName = "SMOKE")
    void performLogin_AddToCart_Checkout_LogoutTest(ITestContext context) {
        MyAccountPage myAccountPage = performLogin(context);
        Assert.assertEquals(myAccountPage.getTitle(), "My Account");

        ProductsListPage productsListPage = myAccountPage.searchFor(FrameworkConstants.getSmokeSuiteSearchProduct());
        String productPageTitle = "Search - " + FrameworkConstants.getSmokeSuiteSearchProduct();
        Assert.assertEquals(productsListPage.getTitle(), productPageTitle);

        ProductPage productPage = productsListPage.clickOnProduct();
        Assert.assertEquals(productPage.getTitle().toLowerCase(), FrameworkConstants.getSmokeSuiteSearchProduct());

        CheckoutPage checkoutPage = productPage.addToCart();
        Assert.assertEquals(checkoutPage.getTitle(), "Checkout");
        Assert.assertTrue(checkoutPage.comparePrices());
        Assert.assertEquals(checkoutPage.getQuantityInputValue(), 1);

        LogoutPage logoutPage = new HomePage().clickOnLogoutLink();
        Assert.assertEquals(logoutPage.getTitle(), "Account Logout");
    }

    private MyAccountPage performLogin(ITestContext context) {
        String email = (String) context.getSuite().getAttribute("email");
        String password = (String) context.getSuite().getAttribute("password");

        LoginPage loginPage = new HomePage().clickOnLoginLink();
        return loginPage.enterValues(email, password).clickOnLoginButton();
    }
}
