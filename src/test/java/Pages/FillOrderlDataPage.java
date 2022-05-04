package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillOrderlDataPage {
    WebDriver driver;

    public FillOrderlDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "select[id=\"BillingNewAddress_CountryId\"] > option[value=\"123\"]")
    WebElement CountrySelector;
    @FindBy(css = "select[id=\"BillingNewAddress_StateProvinceId\"] > option[value=\"0\"]")
    WebElement StateSelector;
    @FindBy(css = "input[id=\"shippingoption_1\"]")
    WebElement ShippingMethodSelector;
    @FindBy(css = "input[id=\"paymentmethod_1\"]")
    WebElement PaymentMethodSelector;
    @FindBy(css = "select[id=\"CreditCardType\"] > option[value=\"MasterCard\"]")
    WebElement CreditCardSelector;
    @FindBy(css = "select[id=\"ExpireMonth\"] > option[value=\"3\"]")
    WebElement ExpDateMonthSelector;
    @FindBy(css = "select[id=\"ExpireYear\"] > option[value=\"2024\"]")
    WebElement ExpDateYearSelector;



    public WebElement EnterCity(){return  driver.findElement(By.id("BillingNewAddress_City"));}
    public WebElement EnterAddress1(){return  driver.findElement(By.id("BillingNewAddress_Address1"));}
    public WebElement EnterPostalCode(){return  driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));}
    public WebElement EnterPhoneNumber(){return  driver.findElement(By.id("BillingNewAddress_PhoneNumber"));}
    public WebElement EnterFaxNumber(){return  driver.findElement(By.id("BillingNewAddress_FaxNumber"));}
    public WebElement EnterCardHolderName(){return  driver.findElement(By.id("CardholderName"));}
    public WebElement EnterCardNumber(){return driver.findElement(By.id("CardNumber"));}
//    public WebElement EnterExpDateMonth(){return  driver.findElement(By.cssSelector("select[id=\"ExpireMonth\"] > option[value=\"3\"]"));}
//    public WebElement EnterExpDateYear(){return  driver.findElement(By.cssSelector("select[id=\"ExpireYear\"] > option[value=\"2024\"]"));}
    public WebElement EnterCardCode(){return driver.findElement(By.id("CardCode"));}

    public void FillPersonalDataSteps(String city, String address1 , String postalcode, String phonenumber , String faxnumber)
    {
        CountrySelector.click();
        StateSelector.click();
        EnterCity().sendKeys(city);
        EnterAddress1().sendKeys(address1);
        EnterPostalCode().sendKeys(postalcode);
        EnterPhoneNumber().sendKeys(phonenumber);
        EnterFaxNumber().sendKeys(faxnumber);

    }

    public void SelectShippingData()
    {
        ShippingMethodSelector.click();

    }

    public void SelectPaymentMethod()
    {
        PaymentMethodSelector.click();
    }

    public void EnterPaymentInformation(String CardHolderName , String CardNumber , String CC )
    {
        CreditCardSelector.click();
        EnterCardHolderName().sendKeys(CardHolderName);
        EnterCardNumber().sendKeys(CardNumber);
        ExpDateMonthSelector.click();
        ExpDateYearSelector.click();
        EnterCardCode().sendKeys(CC);

    }
}
