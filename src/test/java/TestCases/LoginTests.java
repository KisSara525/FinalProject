package TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;


public class LoginTests extends BasePage {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginWithLockedUser(){
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

}
