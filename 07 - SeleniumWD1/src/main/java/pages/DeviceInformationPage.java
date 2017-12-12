package pages;

import org.openqa.selenium.By;

public class DeviceInformationPage extends BasePage {
    private By addToCartButton = By.xpath("(//A[@data-href='https://cart.onliner.by'][text()='В корзину'][text()='В корзину'])[1]");
    private By cartButton = By.xpath("//A[@href='https://cart.onliner.by/']");

    public void clickToAddToBacketButton() {
        BasePage.waitVisibilityOfElement(addToCartButton);
        getDriver().findElements(addToCartButton).get(0).click();
    }

    public OnlinerCartPage clickToCartButton() {
        BasePage.waitVisibilityOfElement(cartButton);
        getDriver().findElement(cartButton).click();
        return new OnlinerCartPage();
    }
}
