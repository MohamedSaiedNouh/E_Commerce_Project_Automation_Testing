package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ResetPasswordStepDefinition {
    WebDriver driver;
    LoginPage loginPage;
    @When("user navigates to the login page and clicks on Forgot password")
    public void GotoLoginPageThenForgetPassword()
    {
        //  Create New Objects
        this.driver = new OpenBrowser().getDriver();

        // GoTo Login Page
        driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]")).click();
        // Click On Forget Password
        driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]")).click();
    }

    @And("^user enters \"(.*)\" his/her email address$")
    public void EnterEmail (String email)
    {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("user clicks on RECOVER button")
    public void ClickonRecover() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]")).click();
        Thread.sleep(3000);
    }

    @Then("user receives an Email with instructions has been sent to you")
    public void ResetMessage()
    {
        SoftAssert softAssert = new SoftAssert();
        // Assert Displaying of Reset Password Message
        String expectedResult = "Email with instructions has been sent to you." ;
        String actualResult   = driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
        softAssert.assertTrue(actualResult.contains(expectedResult),"Reset Password Message");


    }
}
