package StepDefinitions;

import Pages.CurrencySelectorPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class CurrencySwitchStepDefinition {
    WebDriver driver;
    CurrencySelectorPage currencySelectorPage;

    @When("user selects Euro from Currencies List")
    public void CurrencySwitching() throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        currencySelectorPage = new CurrencySelectorPage (driver);
        currencySelectorPage.CurrencySelectionSteps();
        Thread.sleep(3000);
    }

    @When("user could switch from USD to Euro")
    public void SuccessfulCurrencySwitching()
    {
        SoftAssert softAssert = new SoftAssert();
        String USDSelection = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).getText();
        softAssert.assertTrue(USDSelection.contains("Euro"));
        softAssert.assertAll();
    }

}
