package StepDefinitions;

import Pages.FillOrderlDataPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CreateOrderStepDefinition {
    WebDriver driver;
    FillOrderlDataPage fillOrderlDataPage;

    @And("user checks the terms of service and clicks on CHECKOUT")
    public void Checkout()
    {
        this.driver = new OpenBrowser().getDriver();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @And("^user selects Egypt as country , Other as State then enters \"(.*)\" as City , \"(.*)\" as Address 1 , \"(.*)\" as Postal Code , \"(.*)\" as Phone Number , \"(.*)\" as Fax Number$")
    public void FillPersonalData(String city, String address1 , String postalcode, String phonenumber , String faxnumber) throws InterruptedException {
        Thread.sleep(3000);
        fillOrderlDataPage = new FillOrderlDataPage(driver);
        fillOrderlDataPage.FillPersonalDataSteps(city,address1,postalcode,phonenumber,faxnumber);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[id=\"billing-buttons-container\"] > button[name=\"save\"]")).click();
        Thread.sleep(3000);

    }

    @And("user selects shipping method")
    public void ShippingMethodSelection() throws InterruptedException {
        fillOrderlDataPage.SelectShippingData();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]")).click();
        Thread.sleep(3000);

    }

    @And("user selects payment method")
    public void PaymentMethodSelection() throws InterruptedException {
        fillOrderlDataPage.SelectPaymentMethod();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]")).click();
        Thread.sleep(3000);

    }

    @And("^user enters payment information , \"(.*)\" as Card holder name , \"(.*)\" as Card number , \"(.*)\" as CC$")
    public void PaymentInformationEntry(String CardHolderName , String CardNumber , String CC ) throws InterruptedException {
        fillOrderlDataPage.EnterPaymentInformation(CardHolderName,CardNumber,CC);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]")).click();
        Thread.sleep(3000);
    }

    @And("user clicks on CONFIRM")
    public void OrderConfirmation() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class=\"button-1 confirm-order-next-step-button\"]")).click();
        Thread.sleep(3000);
    }

    @Then("user could successfully make an order")
    public void AssertSuccessfulOrder()
    {
        SoftAssert softAssert = new SoftAssert();
        // 1. First Assertion (Assert Successful Message)
        String ExpectedMessage = "Your order has been successfully processed!";
        String ActualMessage   = driver.findElement(By.cssSelector("div[class=\"section order-completed\"] > div[class=\"title\"] > strong")).getText();
        softAssert.assertTrue(ActualMessage.contains(ExpectedMessage));
        // 2. Second Assertion (Assert Continue button is displayed)
        softAssert.assertTrue(driver.findElement(By.cssSelector("button[class=\"button-1 order-completed-continue-button\"]")).isDisplayed());
        softAssert.assertAll();

    }

}
