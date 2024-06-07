package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By quantityInput = By.xpath("//*[@id='checkout-cart']/table/tbody/tr/td[3]/div/input");
    private final By unitPriceTableCell = By.xpath("//*[@id='checkout-cart']/table/tbody/tr/td[4]");
    private final By totalTableCell = By.xpath("//*[@id='checkout-cart']/table/tbody/tr/td[5]");

    public boolean comparePrices() {
        String unitPriceTableCellValue = find(unitPriceTableCell).getText();
        String totalTableCellValue = find(totalTableCell).getText();

        return unitPriceTableCellValue.equals(totalTableCellValue);
    }

    public int getQuantityInputValue() {
        return Integer.parseInt(find(quantityInput).getAttribute("value"));
    }
}
