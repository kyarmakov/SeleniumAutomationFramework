package pages;

import org.openqa.selenium.By;

public final class ProductPage extends BasePage {
    private final By addToCartButton = By.xpath("//div[@id='entry_216842']/button");
    private final By checkoutLink = By.xpath("//div[@id='notification-box-top']/div/div[2]/div[2]/div[2]/a");

    public CheckoutPage addToCart() {
        click(addToCartButton);
        click(checkoutLink);

        return new CheckoutPage();
    }
}
