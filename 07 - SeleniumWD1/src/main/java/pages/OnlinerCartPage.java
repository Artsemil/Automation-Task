package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlinerCartPage extends BasePage {
    private By devicesInTheCart = By.xpath("//div[@class='cart-product-title__link cart-product-title__link_name']");

    public List<WebElement> getAllDevicesInTheCart() {
        BasePage.waitVisibilityOfElement(devicesInTheCart);
        return getDriver().findElements(devicesInTheCart);
    }
}
