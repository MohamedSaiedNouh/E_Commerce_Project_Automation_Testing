package StepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class CloseBrowser {
    WebDriver driver;
    @After
    public void CloseBrowser()
    {
        this.driver = new OpenBrowser().getDriver();
        driver.quit();
    }
}
