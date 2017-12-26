package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlinerHomePage extends BasePage {

    @FindBy(css = ".auth-bar__item--text")
    private WebElement enterButton;

    @FindBy(xpath = "//span[contains(text(), 'Каталог')]")
    private WebElement catalogLink;

    public OnlinerHomePage(WebDriver driver) {
        super(driver);
    }

    public OnlinerLoginPage clickOnEnterButton() {
        enterButton.click();

        return new OnlinerLoginPage(getDriver());
    }

    public OnlinerCatalogPage clickOnCatalogLink() {
        catalogLink.click();
        return new OnlinerCatalogPage(getDriver());
    }
}
