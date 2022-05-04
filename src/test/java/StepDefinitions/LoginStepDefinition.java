package StepDefinitions;

import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class LoginStepDefinition {
    WebDriver driver;
    LoginPage loginPage;

    @When("user navigates to the login page")
    public void GotoLoginPage()
    {
        //  Create New Objects
        this.driver = new OpenBrowser().getDriver();
        loginPage = new LoginPage(driver);

        driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]")).click();

    }

   @And("^user enters \"(.*)\" as an Email and \"(.*)\" as password$")
    public void EnterValidData(String email, String password)
   {
       loginPage.LoginSteps(email,password);
   }

   @And("user clicks on LOGIN button")
    public void ClickLoginButton() throws InterruptedException {
       driver.findElement(By.cssSelector("div > button[type=\"submit\"]")).click();
       Thread.sleep(3000);
   }

   @Then("user could login into system successfully then user is directed to homepage")
    public void SuccessfulLogin()
   {
       SoftAssert softAssert = new SoftAssert();
       // Assertions
       // 1. Assert the displaying of Logout button (after Login)
       softAssert.assertTrue( driver.findElement(By.className("ico-logout")).isDisplayed());
       // 2. Assert the displaying of My account button (after Login)
       softAssert.assertTrue( driver.findElement(By.cssSelector("li > a[href=\"/customer/info\"]")).isDisplayed());
       softAssert.assertAll();

   }


}
