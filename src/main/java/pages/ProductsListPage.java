package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public final class ProductsListPage extends BasePage {
    private final By product = By.xpath("//*[@id='mz-product-grid-image-55-212469']");

    public ProductPage clickOnProduct() {
        click(product);
        return new ProductPage();
    }
}
