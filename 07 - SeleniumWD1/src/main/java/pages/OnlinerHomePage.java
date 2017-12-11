package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlinerHomePage extends BasePage {
    //private By containerLocator = By.xpath("//div[contains(@class,'auth-bar--top')]");
    private By enterButtonLocator = By.cssSelector(".auth-bar__item--text");
    private By catalogLinkLocator = By.xpath("//span[contains(text(), 'Каталог')]");

    private WebElement getEnterButtonElement() {
        return getDriver().findElement(enterButtonLocator);
    }

    public OnlinerLoginPage clickOnEnterButton() {
        BasePage.waitVisibilityOfElement(enterButtonLocator);
        getEnterButtonElement().click();
        return new OnlinerLoginPage();
    }

    private WebElement getCatalogLinkElement() {
        return getDriver().findElement(catalogLinkLocator);
    }

    public CatalogOnlinerPage clickOnCatalogLink() {
        BasePage.waitVisibilityOfElement(catalogLinkLocator);
        getCatalogLinkElement().click();
        return new CatalogOnlinerPage();
    }
}
