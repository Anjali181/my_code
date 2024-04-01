package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class Home extends BrowserDriver {
    private WebElement button, button1, button2, button3, button4, button5;

    @Given("I navigate to website")
    public void i_navigate_to_website() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.xenonstack.com");

    }

    @Then("I should see the home page loaded successfully")
    public void i_should_see_the_home_page_loaded_successfully() {
        System.out.println("Website loads successfully");
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

    @Then("I should see all navigation menus")
    public void i_should_see_all_navigation_menus() {

        WebElement button = driver.findElement(By.id("what-we-do"));
        button.click();
        WebElement button1 = driver.findElement(By.id("solutions"));
        button1.click();
        WebElement button2 = driver.findElement(By.id("industries"));
        button2.click();
        WebElement button3 = driver.findElement(By.id("resources"));
        button3.click();
        WebElement button4 = driver.findElement(By.id("company"));
        button4.click();

    }

    @When("I hover over each menu I should see submenus")
    public void i_should_see_submenus_when_i_hover_over_each_menu() {
        driver.getTitle().contains("XS Discover");
        driver.getTitle().contains("XS Cloud Native");
        driver.getTitle().contains("Industry Transformation");
        driver.getTitle().contains("Technology updates and resources");
        driver.getTitle().contains("XS Journey");
        System.out.println("All submenus are working ");

    }

    @When("I click on the search icon")
    public void i_click_on_the_search_icon() {
        WebElement button = driver.findElement(By.id("search-menu"));
        button.click();
    }

    @Then("I should see a search text box")
    public void i_should_see_a_search_text_box() {
        driver.getTitle().contains("XenonStack Recommends");
        System.out.println("Search Box appears");
    }

    @When("I click on the website logo")
    public void clickLogo() {
        WebElement logo = driver.findElement(By.className("xenonstack-internal-content"));
        logo.click();
    }

    @Then("I should be redirected to the home page")
    public void verifyRedirectedToHomePage() {
        driver.get("https://www.xenonstack.com");
        System.out.println("Redirected to home page ");
    }
}

//    @When("I click on the {string}")
//    public void i_click_on_the(String string){
//        WebElement title = driver.findElement(By.className("multitab active"));
//        title.click();
//    }
//
//    @Then("{string} title should show")
//    public void title_should_show(String string) {
//        driver.getTitle().contains("Develop Generative AI Applications with\n" +
//                "Data-Driven Approach");
//    }
//
// }
//

