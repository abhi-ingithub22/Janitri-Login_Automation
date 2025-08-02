
package tests;
import java.lang.InterruptedException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled with empty fields");
    }

    @Test
    public void testPasswordMaskedbutton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("abhirup@Test25");
        Thread.sleep(3000);  // wait to observe
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default");
        loginPage.togglePasswordVisibility();
        Thread.sleep(3000);  // wait to observe
        Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be visible after toggling");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword("abhirup@Test25");
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        System.out.println("Error message found: " + error);
        Assert.assertFalse(error.isEmpty(), "Error message should appear for invalid login");
    }
}
