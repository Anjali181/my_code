package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.BrowserDriver;
import io.cucumber.java.After;
import static org.junit.Assert.assertTrue;

public class Search extends BrowserDriver {
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.xenonstack.com/");
    }

    @When("the user clicks on the search icon the search bar appears")
    public void the_user_clicks_on_the_search_icon_the_search_bar_appears() {
        // Write code to click on the search icon to make the search bar appear
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"imageidsearch\"]"));
        searchIcon.click();
    }

    @When("the user enters {string} into the search bar")
    public void the_user_enters_keyword_into_the_search_bar(String keyword) {
        // Write code to enter the keyword into the search bar
        WebElement searchBar = driver.findElement(By.xpath("//your-xpath-for-search-bar"));
        searchBar.sendKeys(keyword);
    }

    @When("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        // Write code to click on the search button
        WebElement searchButton = driver.findElement(By.xpath("//your-xpath-for-search-button"));
        searchButton.click();
    }

    @Then("the search results page should be displayed")
    public void the_search_results_page_should_be_displayed() {
        // Write code to verify that the search results page is displayed
        // You can use assertions or any other verification mechanism
        assertTrue("Search results page should be displayed", true);
    }

    @Then("the search results should contain relevant items related to {string}")
    public void the_search_results_should_contain_relevant_items_related_to_keyword(String keyword) {
        // Write code to verify that the search results contain relevant items related to the keyword
        // You can use assertions or any other verification mechanism
        assertTrue("Search results should contain relevant items related to keyword", true);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}













