package pages;

import org.openqa.selenium.By;

public class CatalogOnlinerPage extends BasePage{
    private By mobileCatalogLink = By.xpath("//li/a[@href='https://catalog.onliner.by/mobile']");

    public MobileCatalogOnlinerPage clickToMobileCatalogLink(){
        BasePage.waitVisibilityOfElement(mobileCatalogLink);
        getDriver().findElement(mobileCatalogLink).click();
        return new MobileCatalogOnlinerPage();
    }
}
