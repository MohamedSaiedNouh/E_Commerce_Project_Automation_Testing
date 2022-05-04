package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.sql.Struct;

public class AddShoppingCartStepDefinition {
    WebDriver driver;
    static String product1;
    static String product2;


    @And("^user clicks on ADD TO CART for adding product to cart$")
    public void AddToCart() throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        driver.findElement(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]")).click();
        Thread.sleep(5000);

    }
    @And("^user selects a category for example \"(.*)\" then hover and open sub-Category for example \"(.*)\"$")
    public void AddAnotherProductToCart(String category , String sub_category) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement list = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] >li > a[href=\"/electronics\"]"));
        WebElement subcategory = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] > li > ul[class=\"sublist first-level\"] > li > a[href=\"/others\"]"));
        action.moveToElement(list).moveToElement(subcategory).click().build().perform();
        Thread.sleep(2000);
        product2 = driver.findElement(By.cssSelector("h2[class=\"product-title\"] > a[href=\"/beats-pill-20-wireless-speaker\"]")).getText();
        Thread.sleep(3000);
    }

    @And("user clicks on shopping cart")
    public void GotoShoppingCart() throws InterruptedException {
        driver.findElement(By.id("topcartlink")).click();
        Thread.sleep(3000);
    }

    @Then("user should find the selected products in the shopping cart section")
    public void AssertSuccessfulAddingToCart()
    {
        // Assertions
        // Assert that product 1&2 are added to shopping cart
        SoftAssert softAssert = new SoftAssert();
        product1 = new SearchStepDefinition().getProduct();
        String cartProduct1 = driver.findElement(By.cssSelector("td[class=\"product\"] > a[href=\"/nokia-lumia-1020\"]")).getText();
        String cartProduct2 = driver.findElement(By.cssSelector("td[class=\"product\"] > a[href=\"/beats-pill-20-wireless-speaker\"]")).getText();
        softAssert.assertTrue(cartProduct1.contains(product1),"Product 1 not found in cart");
        softAssert.assertTrue(cartProduct2.contains(product2),"Product 2 not found in cart");
        softAssert.assertAll();

    }

}
