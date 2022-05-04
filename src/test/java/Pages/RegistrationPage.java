package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    public  RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gender-male")
    WebElement SelectGender;
    @FindBy(css = "div > select[name=\"DateOfBirthDay\"] > option[value=\"15\"]")
    WebElement SelectDateOfBirthday;
    @FindBy(css = "div > select[name=\"DateOfBirthMonth\"] > option[value=\"3\"]")
    WebElement SelectDateOfBirthMonth;
    @FindBy(css = "div > select[name=\"DateOfBirthYear\"] > option[value=\"1995\"]")
    WebElement SelectDateOfBirthYear;

    public WebElement EnterFirstName() {return driver.findElement(By.id("FirstName"));}
    public WebElement EnterLastName (){return   driver.findElement(By.id("LastName")); }
    public WebElement EnterEmail (){return   driver.findElement(By.id("Email")); }
    public WebElement EnterCompanyName (){return   driver.findElement(By.id("Company")); }
    public WebElement EnterPassword (){return   driver.findElement(By.id("Password")); }
    public WebElement ConfirmPassword (){return   driver.findElement(By.id("ConfirmPassword")); }

    public void RegisterSteps(String firstname,String lastname,String Email,String Company,String password)
    {
        SelectGender.click();
        EnterFirstName().sendKeys(firstname);
        EnterLastName().sendKeys(lastname);
        SelectDateOfBirthday.click();
        SelectDateOfBirthMonth.click();
        SelectDateOfBirthYear.click();
        EnterEmail().sendKeys(Email);
        EnterCompanyName().sendKeys(Company);
        EnterPassword().sendKeys(password);
        ConfirmPassword().sendKeys(password);
    }


}
