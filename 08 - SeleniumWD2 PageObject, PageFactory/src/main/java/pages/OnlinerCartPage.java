package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-product-title__link cart-product-title__link_name']")
    private List<WebElement> devicesInTheCart;

    public OnlinerCartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllDevicesInTheCart() {
        return this.devicesInTheCart;
    }
}
