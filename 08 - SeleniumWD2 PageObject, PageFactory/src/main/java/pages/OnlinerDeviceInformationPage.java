package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerDeviceInformationPage extends BasePage {

    @FindBy(xpath = "//A[@data-href='https://cart.onliner.by'][text()='В корзину'][text()='В корзину'])[1]")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//A[@href='https://cart.onliner.by/']")
    private WebElement cartButton;

    public OnlinerDeviceInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickToAddToBacketButton() {
        addToCartButton.get(0).click();
    }

    public OnlinerCartPage clickToCartButton() {
        waitVisibilityOfElement(cartButton);
        cartButton.click();
        return new OnlinerCartPage(getDriver());
    }
}
