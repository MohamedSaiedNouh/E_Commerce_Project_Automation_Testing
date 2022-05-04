package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrencySelectorPage {
    WebDriver driver;


    public CurrencySelectorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "customerCurrency")
    WebElement CurrencySelector;
    @FindBy(css = "option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]")
    WebElement USDSelection;
    @FindBy(css = "option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")
    WebElement EuroSelection;
    public void CurrencySelectionSteps() throws InterruptedException {
//        CurrencySelector.click();
//        USDSelection.click();
        CurrencySelector.click();
        EuroSelection.click();
        Thread.sleep(3000);

    }
}
