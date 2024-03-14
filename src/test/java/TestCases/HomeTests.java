package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BasePage {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        driver.get("https://www.saucedemo.com/inventory.html");

        homePage = new HomePage(driver);
    }

    @Test
    public void testProductListDisplayed() {
        Assert.assertTrue(homePage.isProductListDisplayed(), "Product list is not displayed on the inventory page");
    }

    @Test
    public void testAddToCartButtonFunctionality() {
        homePage.clickAddToCartButton();
        Assert.assertEquals(homePage.getAddToCartButtonText().toLowerCase(), "remove", "Add to Cart button text did not change to Remove");
    }

    @Test
    public void testRemoveFromCartButtonFunctionality() {
        homePage.clickAddToCartButton();
        homePage.clickRemoveFromCartButton();
        Assert.assertEquals(homePage.getAddToCartButtonText().toLowerCase(), "add to cart", "Remove from Cart button text did not change to Add to Cart");
    }

}
