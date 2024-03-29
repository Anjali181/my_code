package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import utility.BrowserDriver;

public class Home extends BrowserDriver {
    @Given("the user opens the browser")
    public void the_user_opens_the_browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @When("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        driver.get("https://www.xenonstack.com");
    }

    @Then("the homepage should load successfully")
    public void the_homepage_should_load_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.xenonstack.com"));
    }

    // Remember to close the browser after each scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}