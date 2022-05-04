package StepDefinitions;

import Pages.RegistrationPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser extends ExternalResource {

    static WebDriver driver = null;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

//    @Given("user opens browser")
    @Before
    public void OpenBrowser() throws InterruptedException {
        // 1. Bridge between Test Scripts and Browsers to be used in testing
        String chromePath =  System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        // 2. Create New Object from WebDriver
        driver = new ChromeDriver();

        // 3. Navigate to E-commerce Website and Wait for 3 Seconds
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

}
