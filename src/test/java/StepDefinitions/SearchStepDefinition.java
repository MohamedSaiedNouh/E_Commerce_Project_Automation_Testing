package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SearchStepDefinition {
    WebDriver driver;
    static String Product;

    public String getProduct() {
        return Product;
    }

    @Given("user is already logged with \"(.*)\" and \"(.*)\"$")
    public void AlreadyLogged(String email, String password) throws InterruptedException {
        this.driver = new OpenBrowser().getDriver();
        LoginStepDefinition  loginStepDefinition = new LoginStepDefinition();
        loginStepDefinition.GotoLoginPage();
        loginStepDefinition.EnterValidData(email, password);
        loginStepDefinition.ClickLoginButton();
        loginStepDefinition.SuccessfulLogin();
    }

    @When("user searches for \"(.*)\"$")
    public void SearchForProduct(String product) {
        driver.findElement(By.id("small-searchterms")).sendKeys(product);
        driver.findElement(By.id("small-searchterms")).submit();
        this.Product = product;
    }


    @Then("user could navigate to product page")
    public void NavigateToProductPage()
    {
        // Navigate to First Option in Searching Results
        driver.findElement(By.cssSelector("h2 > a[href=\"/nokia-lumia-1020\"]")).click();
        // Assertions
        // Assert that the first result page contains the name of the product searched by user
        SoftAssert softAssert = new SoftAssert();
        String ProductName = driver.findElement(By.cssSelector("div > h1")).getText();
        softAssert.assertTrue(ProductName.contains(Product));
        softAssert.assertAll();

    }

}