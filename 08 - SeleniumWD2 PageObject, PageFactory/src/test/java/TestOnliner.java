import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import resources.Catalog;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestOnliner {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Dev\\Automation\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAddDeviceIntoCart() {
        Random randomNumber = new Random();
        String url = "https://www.onliner.by/";
        String email = "fuyawej@p33.org";
        String password = "qwerty123";
        driver.get(url);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage(driver);
        OnlinerLoginPage onlinerLoginPage = onlinerHomePage.clickOnEnterButton();
        onlinerLoginPage.sendKeysToEmailField(email);
        onlinerLoginPage.sendKeysTopasswordField(password);
        onlinerLoginPage.clickOnLoginButton();
        OnlinerCatalogPage catalogOnlinerPage;
        try {
            catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        }catch (Exception e){
            System.out.println("Captcha during login!");
            driver.get(url);
            catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        }
        OnlinerSelectedCatalogPage selectedCatalogOnlinerPage = catalogOnlinerPage.clickToSelectedCatalogLink(Catalog.MOBILE);
        List<WebElement> devices = selectedCatalogOnlinerPage.getDevicesList();
        WebElement randomDevice = selectedCatalogOnlinerPage.getActiveDevice(devices, randomNumber.nextInt(devices.size()));
        String randomDeviceName = selectedCatalogOnlinerPage.getDeviceTitel(randomDevice);
        System.out.println(randomDeviceName);
        OnlinerDeviceInformationPage deviceInformationPage = selectedCatalogOnlinerPage.clickOnDeviceLink(randomDevice);
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

//    @AfterClass
//    public static void tearDown(){
//        driver.quit();
//    }
}
