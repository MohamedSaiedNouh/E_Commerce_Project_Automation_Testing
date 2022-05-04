package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class AddWishlistStepDefinition {
    WebDriver driver;
    static String product1;
    static String product2;

    @And("user clicks on Add to wishlist for adding product 1 to wishlist")
    public void AddProduct1ToWishlist()
    {
        this.driver = new OpenBrowser().getDriver();
        driver.findElement(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]")).click();
    }

    @And("user selects a category for ex. Computers then hover and open sub-Category for ex. Software")
    public void AddAnotherProductToWishlist() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement list = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] >li > a[href=\"/computers\"]"));
        WebElement subcategory = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] > li > ul[class=\"sublist first-level\"] > li > a[href=\"/software\"]"));
        action.moveToElement(list).moveToElement(subcategory).click().build().perform();
        Thread.sleep(3000);
        product2 = driver.findElement(By.cssSelector("h2[class=\"product-title\"] > a[href=\"/windows-8-pro\"]")).getText();
        Thread.sleep(3000);
    }
    @And("user clicks on Add product to wishlist for adding product 2 to wishlist")
    public void AddProduct2ToWishlist()
    {
        driver.findElement(By.cssSelector("div[data-productid=\"11\"] > div[class=\"details\"] > div[class=\"add-info\"] > div[class=\"buttons\"] >  button[class=\"button-2 add-to-wishlist-button\"]")).click();;
    }

    @And("user clicks on wishlist")
    public void GotoWishlist() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class=\"header-links\"] > ul > li > a[href=\"/wishlist\"]")).click();
        Thread.sleep(3000);
    }

    @Then("user should find the selected products in the wishlist section")
    public void AssertSuccessfulAddingToWishlist()
    {
        // Assertions
        // Assert that product 1&2 are added to wishlist
        SoftAssert softAssert = new SoftAssert();
        product1 = new SearchStepDefinition().getProduct();
        String cartProduct1 = driver.findElement(By.cssSelector("td[class=\"product\"] > a[href=\"/htc-one-m8-android-l-50-lollipop\"]")).getText();
        String cartProduct2 = driver.findElement(By.cssSelector("td[class=\"product\"] > a[href=\"/windows-8-pro\"]")).getText();
        softAssert.assertTrue(cartProduct1.contains(product1),"Product 1 not found in wishlist");
        softAssert.assertTrue(cartProduct2.contains(product2),"Product 2 not found in wishlist");
        softAssert.assertAll();


    }
}
