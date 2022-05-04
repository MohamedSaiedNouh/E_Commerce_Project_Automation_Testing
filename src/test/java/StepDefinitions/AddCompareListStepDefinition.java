package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AddCompareListStepDefinition {
    WebDriver driver;
    static String product1;
    static String product2;

    @And("user clicks on Add to compare list to add two products into compare list")
    public void AddProductsToCompareList() throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Add Product 1 to compare list
        driver.findElement(By.cssSelector("div[data-productid=\"5\"] > div[class=\"details\"] > div[class=\"add-info\"] > div[class=\"buttons\"] >  button[class=\"button-2 add-to-compare-list-button\"]")).click();
        product1 = driver.findElement(By.cssSelector("h2[class=\"product-title\"] > a[href=\"/asus-n551jk-xo076h-laptop\"]")).getText();
        Thread.sleep(3000);
        // Add Product 2 to compare list
        driver.findElement(By.cssSelector("div[data-productid=\"9\"] > div[class=\"details\"] > div[class=\"add-info\"] > div[class=\"buttons\"] >  button[class=\"button-2 add-to-compare-list-button\"]")).click();
        product2 = driver.findElement(By.cssSelector("h2[class=\"product-title\"] > a[href=\"/lenovo-thinkpad-x1-carbon-laptop\"]")).getText();
        // Scroll down
        js.executeScript("window.scrollBy(0,550)", "");
        Thread.sleep(5000);
    }

    @And("user clicks on compare list")
    public void GotoCompareList() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/compareproducts\"]")).click();
        Thread.sleep(3000);
    }

    @Then("user should find the selected products in the compare list section")
    public void AssertSuccessfulAddingToCompareList() throws InterruptedException {
        // Assertions
        // Assert that product 1&2 are added to compare list
        SoftAssert softAssert = new SoftAssert();
        String compareProduct1 = driver.findElement(By.cssSelector("tr[class=\"product-name\"] > td[style=\"width:45%\"] > a[href=\"/asus-n551jk-xo076h-laptop\"]")).getText();
        String compareProduct2 = driver.findElement(By.cssSelector("tr[class=\"product-name\"] > td[style=\"width:45%\"] > a[href=\"/lenovo-thinkpad-x1-carbon-laptop\"]")).getText();
        softAssert.assertTrue(compareProduct1.contains(product1),"Product 1 not found in wishlist");
        softAssert.assertTrue(compareProduct2.contains(product2),"Product 2 not found in wishlist");
        softAssert.assertAll();
    }
}
