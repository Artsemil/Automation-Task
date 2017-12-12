import org.openqa.selenium.WebElement;
import pages.*;
import resources.Catalog;

import java.util.List;
import java.util.Random;

public class Run {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        String url = "https://www.onliner.by/";
        String email = "fuyawej@p33.org";
        String password = "qwerty123";
        System.setProperty("webdriver.gecko.driver", "C:\\Dev\\Automation\\Drivers\\geckodriver.exe");
        OnlinerHomePage onlinerHomePage = new BasePage().getHomePage(url);
        OnlinerLoginPage onlinerLoginPage = onlinerHomePage.clickOnEnterButton();
        onlinerLoginPage.sendKeysToEmailField(email);
        onlinerLoginPage.sendKeysTopasswordField(password);
        onlinerLoginPage.clickOnLoginButton();
        CatalogOnlinerPage catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        OnlinerSelectedCatalogPage selectedCatalogOnlinerPage = catalogOnlinerPage.clickToSelectedCatalogLink(Catalog.DESKTOPPC);
        List<WebElement> devices = selectedCatalogOnlinerPage.getActiveDevices();
        WebElement randomDevice = selectedCatalogOnlinerPage.getActiveDevice(devices, randomNumber.nextInt(devices.size()));
        String randomDeviceName = selectedCatalogOnlinerPage.getDeviceTitel(randomDevice);
        DeviceInformationPage deviceInformationPage = selectedCatalogOnlinerPage.clickOnDeviceLink(randomDevice);
        deviceInformationPage.clickToAddToBacketButton();
        OnlinerCartPage onlinerCartPage = deviceInformationPage.clickToCartButton();
        devices = onlinerCartPage.getAllDevicesInTheCart();
        for (WebElement element : devices) {
            if (element.getText().equals(randomDeviceName)) {
                System.out.println("Devise added in the cart");
                break;
            }
        }
    }
}
