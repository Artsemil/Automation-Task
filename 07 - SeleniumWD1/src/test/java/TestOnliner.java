import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.*;
import resources.Catalog;

import java.util.List;
import java.util.Random;

public class TestOnliner {
    @Test
    public void testAddDeviceIntoCart() {
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
        CatalogOnlinerPage catalogOnlinerPage;
        try {
            catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        }catch (Exception e){
            System.out.println("Captcha during login!");
            BasePage.getDriver().get(url);
            catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        }
        OnlinerSelectedCatalogPage selectedCatalogOnlinerPage = catalogOnlinerPage.clickToSelectedCatalogLink(Catalog.MOBILE);
        List<WebElement> devices = selectedCatalogOnlinerPage.getActiveDevices();
        WebElement randomDevice = selectedCatalogOnlinerPage.getActiveDevice(devices, randomNumber.nextInt(devices.size()));
        String randomDeviceName = selectedCatalogOnlinerPage.getDeviceTitel(randomDevice);
        System.out.println(randomDeviceName);
        DeviceInformationPage deviceInformationPage = selectedCatalogOnlinerPage.clickOnDeviceLink(randomDevice);
        deviceInformationPage.clickToAddToBacketButton();
        OnlinerCartPage onlinerCartPage = deviceInformationPage.clickToCartButton();
        devices = onlinerCartPage.getAllDevicesInTheCart();
        boolean elementIsPresent = false;
        for (WebElement element : devices) {
            if (element.getText().equals(randomDeviceName)) {
                elementIsPresent = true;
                break;
            }
        }
        Assert.assertTrue(elementIsPresent, "Element didn't add to cart");
    }

    @AfterTest
    public void quit(){
        BasePage.getDriver().quit();
    }
}
