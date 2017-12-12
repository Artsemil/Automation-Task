package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static WebDriver driver = new FirefoxDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    public OnlinerHomePage getHomePage(String url) {
        getDriver().get(url);
        return new OnlinerHomePage();
    }

    public static void waitVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
