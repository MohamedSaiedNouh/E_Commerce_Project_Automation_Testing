package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SelectedTagsStepDefinition {
    WebDriver driver;
    String tag;

    @When("^user selects \"(.*)\" tag for example from popular tags$")
    public void SelectTag(String tag) throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        this.tag = tag;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li > a[href=\"/apparel-2\"]")).click();
        Thread.sleep(3000);

    }

    @Then("users could directed to the product tagged page")
    public void SuccessfullTagDirection()
    {

        SoftAssert softAssert = new SoftAssert();
        String SelectedTag = driver.findElement(By.cssSelector("div>h1")).getText();
        softAssert.assertTrue(SelectedTag.contains(tag));
    }
}
