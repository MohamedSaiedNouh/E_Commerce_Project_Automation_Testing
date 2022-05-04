package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement EnterEmail() { return driver.findElement(By.id("Email")); }
    public WebElement Enterpassword() {return driver.findElement(By.id("Password"));}

    public void LoginSteps(String email,String password)
    {
        EnterEmail().sendKeys(email);
        Enterpassword().sendKeys(password);
    }
}
