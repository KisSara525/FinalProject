package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        driver.get("https://www.saucedemo.com/inventory.html");

    }

    // Example of elements on the Home Page
    @FindBy(className = "btn_inventory")
    private WebElement addToCartButton;

    @FindBy(className = "inventory_list")
    private WebElement productList;
    @FindBy(className = "shopping_cart_badge")

    private WebElement cartBadge;

    public boolean isProductListDisplayed() {
        return productList.isDisplayed();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getAddToCartButtonText() {
        return addToCartButton.getText();
    }

    public void clickRemoveFromCartButton() {
        addToCartButton.click();
    }

}

