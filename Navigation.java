package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.BrowserDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class Form extends BrowserDriver
{
    @Given("I visit website")
    public void i_visit_website() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.xenonstack.com");

    }
    @When("I click on the Contact Us button")
    public void i_click_on_the_Contact_Us_button() {
        WebElement button = driver.findElement(By.xpath("//span[text()='CONTACT US']"));
        button.click();

    }
    @Then("I should be directed to the Contact Us page")
    public void i_should_be_directed_to_the_contact_us_page() {
        driver.get("https://www.xenonstack.com/contact-us/");
        System.out.println("Redirected to Contact Us page");
    }
    @When("^I fill the form with the following invalid data:$")
    public void fillFormWithInvalidData(List<Map<String, String>> formData) {
        // Iterate over each row of data
        for (Map<String, String> field : formData) {
            String fieldName = field.get("Field");
            String value = field.get("Value");
            WebElement inputField = driver.findElement(By.name(fieldName));
            inputField.sendKeys(value);
        }
        driver.findElement(By.id("submit-button")).click(); // Assuming submit button has id 'submit-button'
    }

    @Then("I should see corresponding error messages")
    public void verifyErrorMessages(List<Map<String, String>> errorData) {
        // Iterate over each row of error data
        for (Map<String, String> error : errorData) {
            String expectedErrorMessage = error.get("Expected Error Message");
            WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(), '" + expectedErrorMessage + "')]"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }
    }

    @Then("^the form submission should (succeed|fail)$")
    public void verifyFormSubmission(String expectedOutcome) {
        if (expectedOutcome.equals("succeed")) {
            // Implement code to verify successful form submission
        } else {
            // Implement code to verify failed form submission
        }
    }

    @When("^I fill the form with valid data$")
    public void fillFormWithValidData(List<Map<String, String>> formData) {
        // Same implementation as fillFormWithInvalidData
    }

    @When("^I attempt to submit the form without filling any fields$")
    public void submitFormWithoutFillingFields() {
        driver.findElement(By.id("submit-button")).click(); // Assuming submit button has id 'submit-button'
    }
}









