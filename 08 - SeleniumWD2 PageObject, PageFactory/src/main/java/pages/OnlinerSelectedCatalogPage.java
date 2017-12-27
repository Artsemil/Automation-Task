package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerSelectedCatalogPage extends BasePage {

    @FindBy(css = ".schema-product__group")
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
        return device.findElement(By.xpath(".//div[@class='schema-product__title']")).getText();
    }

    public OnlinerDeviceInformationPage clickOnDeviceLink(WebElement device) {
        device.findElement(By.xpath(".//div[@class='schema-product__offers']/a")).click();
        return new OnlinerDeviceInformationPage(getDriver());
    }
}
