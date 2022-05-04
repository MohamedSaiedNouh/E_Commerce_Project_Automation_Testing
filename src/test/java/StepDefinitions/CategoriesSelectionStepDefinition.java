package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class CategoriesSelectionStepDefinition {
    WebDriver driver;


    @When("^user selects any category for example \"(.*)\" then hover and open sub-Category for example \"(.*)\"$")
    public void Select_Hover_Open(String category , String sub_category) throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        Actions action = new Actions(driver);
        WebElement list = driver.findElement(By.cssSelector("li > a[href=\"/apparel\"]"));
        WebElement subcategory = driver.findElement(By.cssSelector("li > a[href=\"/shoes\"]"));
        action.moveToElement(list).moveToElement(subcategory).click().build().perform();
        Thread.sleep(3000);
    }
    @Then("^user could navigate to the landing page of this sub-Category \"(.*)\"$")
    public void SuccessfulAccessingSubcategory(String sub_category)
    {
        SoftAssert softAssert = new SoftAssert();
        String Subcategory = driver.findElement(By.cssSelector("div>h1")).getText();
        System.out.println(Subcategory);
        softAssert.assertTrue(Subcategory.contains(sub_category));
        softAssert.assertAll();
    }
}
