package pages;

import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage{
    private final By searchInput = By.xpath("//input[@name='search']");
    private final By searchButton = By.xpath("//button[@type='submit' and text()='Search']");

    public ProductsListPage searchFor(String value) {
        type(searchInput, value);
        click(searchButton);

        return new ProductsListPage();
    }
}
