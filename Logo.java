package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.BrowserDriver;
import static org.junit.Assert.assertEquals;

public class Logo extends BrowserDriver {

    @Given("the user is on the home")
    public void the_user_is_on_the_home() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.xenonstack.com");
    }

    @When("the user clicks on the logo")
    public void the_user_clicks_on_the_logo() {
    driver.findElement(By.xpath("//*[@id=\"xs-header\"]/div/nav/div/ul[1]/li[1]/a/img")).click();
    }
    @Then("the homepage should be loaded")
    public void the_homepage_should_be_loaded() {
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

