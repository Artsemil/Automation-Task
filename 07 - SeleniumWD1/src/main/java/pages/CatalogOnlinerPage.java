package pages;

import org.openqa.selenium.By;
import resources.Catalog;

public class CatalogOnlinerPage extends BasePage {
    private By mobileCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/mobile']");

    public OnlinerMobileCatalogPage clickToMobileCatalogLink() {
        BasePage.waitVisibilityOfElement(mobileCatalogLink);
        getDriver().findElement(mobileCatalogLink).click();
        return new OnlinerMobileCatalogPage();
    }

    public OnlinerSelectedCatalogPage clickToSelectedCatalogLink(Catalog catalog) {
        By anyCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/" + catalog.toString().toLowerCase() + "']");
        BasePage.waitVisibilityOfElement(anyCatalogLink);
        getDriver().findElement(anyCatalogLink).click();
        return new OnlinerSelectedCatalogPage();
    }
}
