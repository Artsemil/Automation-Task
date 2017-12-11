package pages;

import org.openqa.selenium.By;

public class OnlinerLoginPage extends BasePage {
    private By emailField = By.xpath("//input[@type='text'][@data-field='login']");
    private By passwordField = By.xpath("//input[@type='password'][@data-field='login']");
    private By enterButton = By.xpath("//button[contains(@class,'auth__btn--green')]");

    public void sendKeysToEmailField(String email) {
        BasePage.waitVisibilityOfElement(emailField);
        getDriver().findElement(emailField).sendKeys(email);
    }

    public void sendKeysTopasswordField(String password) {
        BasePage.waitVisibilityOfElement(passwordField);
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton() {
        BasePage.waitVisibilityOfElement(enterButton);
        getDriver().findElement(enterButton).click();
    }
}
