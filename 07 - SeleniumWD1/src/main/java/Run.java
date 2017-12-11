import pages.*;

public class Run {
    public static void main(String[] args) {
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
        MobileCatalogOnlinerPage mobileCatalogOnlinerPage = catalogOnlinerPage.clickToMobileCatalogLink();
    }
}
