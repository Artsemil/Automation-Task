package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerSelectedCatalogPage extends BasePage {
    //private By allDevicesAtPage = By.xpath("div[contains(@class,'schema-product')]");
    //private By activeDeviceOffer = By.xpath("//div//a[contains(@class,'button_orange')]");
    @FindBy(xpath = "//div[contains(@class,'schema-product__title')]")
    private List<WebElement> devicesList;

    public OnlinerSelectedCatalogPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getDevicesList(){
        return this.devicesList;
    }

    public WebElement getActiveDevice(List<WebElement> devices, int number) {
        return devices.get(number);
    }

    public String getDeviceTitel(WebElement device) {
        return device.getText();
    }

    public OnlinerDeviceInformationPage clickOnDeviceLink(WebElement device) {
        device.click();
        return new OnlinerDeviceInformationPage(getDriver());
    }
}
