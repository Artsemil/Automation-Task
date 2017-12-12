package pages;

import org.openqa.selenium.By;
import resources.Catalog;

public class CatalogOnlinerPage extends BasePage{
    private By mobileCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/mobile']");

    public MobileCatalogOnlinerPage clickToMobileCatalogLink(){
        BasePage.waitVisibilityOfElement(mobileCatalogLink);
        getDriver().findElement(mobileCatalogLink).click();
        return new MobileCatalogOnlinerPage();
    }

    public SelectedCatalogOnlinerPage clickToSelectedCatalogLink(Catalog catalog){
        By anyCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/" + catalog.toString().toLowerCase() +"']");
        BasePage.waitVisibilityOfElement(anyCatalogLink);
        getDriver().findElement(anyCatalogLink).click();
        return new SelectedCatalogOnlinerPage();
    }
}
