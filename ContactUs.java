package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import io.cucumber.java.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.BrowserDriver;

import static org.junit.Assert.assertTrue;
public class ContactUs extends BrowserDriver {
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.xenonstack.com"); // Replace with your homepage URL
    }

    @When("the user clicks on the CONTACT US button")
    public void the_user_clicks_on_the_contact_us_button() {
        // Locate and click the CONTACT US button
        WebElement contactUsButton = driver.findElement(By.xpath("//*[@id=xs-header]/div/nav/div/ul[2]/li[1]"));
        contactUsButton.click();
    }

    @Then("the user should be navigated to the contact-us page")
    public void the_user_should_be_navigated_to_the_contact_us_page() {
        String expectedURL = "https://www.xenonstack.com/contact-us"; // Replace with the expected URL of the contact us page
        assertTrue("Contact Us page should be displayed", driver.getCurrentUrl().contains(expectedURL));
    }

    // Remember to close the browser after each scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





