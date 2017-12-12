package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlinerSelectedCatalogPage extends BasePage {
    //private By allDevicesAtPage = By.xpath("div[contains(@class,'schema-product')]");
    //private By activeDeviceOffer = By.xpath("//div//a[contains(@class,'button_orange')]");
    private By deviceTitles = By.xpath("//div[contains(@class,'schema-product__title')]");


    public List<WebElement> getActiveDevices() {
        BasePage.waitVisibilityOfElement(deviceTitles);
        return getDriver().findElements(deviceTitles);
    }

    public WebElement getActiveDevice(List<WebElement> devices, int number) {
        return devices.get(number);
    }

    public String getDeviceTitel(WebElement device) {
        return device.getText();
    }

    public DeviceInformationPage clickOnDeviceLink(WebElement device) {
        device.click();
        return new DeviceInformationPage();
    }
}
