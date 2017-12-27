package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlinerLoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='text'][@data-field='login']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password'][@data-field='login']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class,'auth__btn--green')]")
    private WebElement enterButton;

    public OnlinerLoginPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysToEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void sendKeysTopasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        enterButton.click();
    }
}
