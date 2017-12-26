package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.Catalog;

public class OnlinerCatalogPage extends BasePage {

    @FindBy(xpath = "/li/a[@href='https://catalog.onliner.by/mobile']")
    private WebElement mobileCatalogLink;

    public OnlinerCatalogPage(WebDriver driver) {
        super(driver);
    }

    public OnlinerMobileCatalogPage clickToMobileCatalogLink() {
        mobileCatalogLink.click();
        return new OnlinerMobileCatalogPage(getDriver());
    }

    public OnlinerSelectedCatalogPage clickToSelectedCatalogLink(Catalog catalog) {
        By anyCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/" + catalog.toString().toLowerCase() + "']");
        getDriver().findElement(anyCatalogLink).click();
        return new OnlinerSelectedCatalogPage(getDriver());
    }
}
