package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectedCatalogOnlinerPage extends BasePage {
    private By allDevicesAtPage = By.xpath("div[contains(@class,'schema-product')]");
    private By deviceTitle = By.xpath("//div[contains(@class,'schema-product__title')]");
    private By activeDeviceOffer = By.xpath("//div//a[contains(@class,'button_orange')]");

    public List<WebElement> getActiveDevices() {
        BasePage.waitVisibilityOfElement(activeDeviceOffer);
        return getDriver().findElement(allDevicesAtPage).findElements(activeDeviceOffer);
    }

    public WebElement getActiveDevice(List<WebElement> devices, int number) {
        return devices.get(number);
    }

    public String getDeviceTitel(WebElement device) {
        return device.findElements(deviceTitle).toString();
    }

}
