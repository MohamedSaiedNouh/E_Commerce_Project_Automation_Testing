package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ColorFilterStepDefinition {
    WebDriver driver;

    @When("user could select any color from colors pane")
    public void ColorFilter() throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-15\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-15\"]")).click();
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-14\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-14\"]")).click();
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-16\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-16\"]")).click();
        driver.findElement(By.cssSelector("li > input[id=\"attribute-option-15\"]")).click();
        Thread.sleep(2000);
    }
    @Then("users could filter with selected color")
    public void SuccessfulColorFiltering()
    {
        // Assertions
        // Assert Red Color is checked (selected)
        SoftAssert softAssert = new SoftAssert();
        boolean SelectedColor = driver.findElement(By.cssSelector("li > input[id=\"attribute-option-15\"]")).isSelected();
        softAssert.assertTrue(SelectedColor);
        softAssert.assertAll();

    }
}
