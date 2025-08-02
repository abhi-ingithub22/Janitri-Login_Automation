
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By userIdField = By.name("email");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[contains(.,'Login')]");
    By passwordToggle = By.cssSelector("button[aria-label='toggle password visibility']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(userIdField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public void togglePasswordVisibility() {
        driver.findElement(passwordToggle).click();
    }

    public boolean isPasswordMasked() {
        WebElement passwordInput = driver.findElement(passwordField);
        return passwordInput.getAttribute("type").equals("password");
    }

    public String getErrorMessage() {
        try {
            WebElement errorMsg = driver.findElement(By.xpath("//div[@class='invalid-credential-div']//p[contains(text(), 'Invalid Credentials')]"));
            return errorMsg.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
