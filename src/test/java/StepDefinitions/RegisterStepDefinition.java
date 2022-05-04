package StepDefinitions;

import Pages.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.Random;

public class RegisterStepDefinition {
    WebDriver driver;
    RegistrationPage registrationPage ;

    public WebDriver getDriver() {
        return driver;
    }

    @When("user navigates to the Registration page")
    public void GotoRegisterPage()
    {
        //  Create New Objects
        this.driver = new OpenBrowser().getDriver();
        registrationPage = new RegistrationPage(driver);

        // Goto Registration Page
        driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]")).click();

    }

    @And("^user enters \"(.*)\" as firstname, \"(.*)\" as lastname, \"(.*)\" as an Email, \"(.*)\" as a company and \"(.*)\" as a password$")
    public void EnterValidData(String firstname,String lastname,String email,String company,String password)  {

        registrationPage.RegisterSteps(firstname,lastname,email,company,password);
    }

    @And("user clicks on REGISTER button")
    public void RegisterButtonClick() throws InterruptedException {
        // Click On Register Button
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(3000);
    }

    @Then("user could Register into system successfully")
    public void SuccessfulRegistration()
    {
        SoftAssert softAssert = new SoftAssert();
        // 1. First Assertion (Assert Successful Registration)
        String expectedResult       = "Your registration completed" ;
        String actualResult         = driver.findElement(By.cssSelector("div > div[class=\"result\"]")).getText();
        softAssert.assertTrue(actualResult.contains(expectedResult),"Successful message is not displayed");
        // 2. Second Assertion (Assert Continue button is displayed)
        softAssert.assertTrue(driver.findElement(By.cssSelector("div > a[class=\"button-1 register-continue-button\"]")).isDisplayed(),"Continue Button is not displayed");
        softAssert.assertAll();
    }
    @And("user is directed to homepage")
    public void DirectionToHompage()
    {
        // Click on Continue Button
        driver.findElement(By.cssSelector("div > a[class=\"button-1 register-continue-button\"]")).click();

    }

}
