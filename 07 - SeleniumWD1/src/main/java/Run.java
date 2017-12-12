import org.openqa.selenium.WebElement;
import pages.*;
import resources.Catalog;

public class Run {
    public static void main(String[] args) {
        String url = "https://www.onliner.by/";
        String email = "fuyawej@p33.org";
        String password = "qwerty123";
        System.setProperty("webdriver.gecko.driver", "C:\\Dev\\Automation\\Drivers\\geckodriver.exe");
        OnlinerHomePage onlinerHomePage = new BasePage().getHomePage(url);
//        OnlinerLoginPage onlinerLoginPage = onlinerHomePage.clickOnEnterButton();
//        onlinerLoginPage.sendKeysToEmailField(email);
//        onlinerLoginPage.sendKeysTopasswordField(password);
//        onlinerLoginPage.clickOnLoginButton();
        CatalogOnlinerPage catalogOnlinerPage = onlinerHomePage.clickOnCatalogLink();
        SelectedCatalogOnlinerPage selectedCatalogOnlinerPage = catalogOnlinerPage.clickToSelectedCatalogLink(Catalog.DESKTOPPC);
        WebElement device = selectedCatalogOnlinerPage.getActiveDevice(selectedCatalogOnlinerPage.getActiveDevices(), 3);
        System.out.println(selectedCatalogOnlinerPage.getDeviceTitel(device));
    }
}
