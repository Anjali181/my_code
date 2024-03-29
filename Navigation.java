package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;
import utility.BrowserDriver;
import org.openqa.selenium.interactions.Actions;
public class Navigation extends BrowserDriver
{
    private Actions actions;

    @Given("the user opens the website")
    public void the_user_opens_the_website() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        driver.get("https://www.xenonstack.com");
    }

    @When("the user hovers over each main navigation link")
    public void the_user_hovers_over_each_main_navigation_link() {
        // Replace "nav-link" with the class or identifier for your main navigation links
        WebElement mainNavLinksContainer = driver.findElement(By.className("desktop-heading"));
        // Replace "sub-menu" with the class or identifier for your sub-navigation menus
        WebElement subMenuContainer = driver.findElement(By.className("xenonstack-internal-content"));

        // Get all main navigation links
        java.util.List<WebElement> mainNavLinks = mainNavLinksContainer.findElements(By.tagName("a"));

        // Hover over each main navigation link to trigger sub-navigation menu
        for (WebElement mainNavLink : mainNavLinks) {
            actions.moveToElement(mainNavLink).perform();
            // Wait for sub-navigation menu to be displayed
            // You may need to adjust this wait time based on your website's behavior
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("the sub-navigation menu should be displayed for each main navigation link")
    public void the_sub_navigation_menu_should_be_displayed_for_each_main_navigation_link() {
        // Replace "sub-menu" with the class or identifier for your sub-navigation menus
        WebElement subMenuContainer = driver.findElement(By.className("xenonstack-internal-content"));

        // Check if sub-navigation menu is displayed
        assertTrue("Sub-navigation menu should be displayed", subMenuContainer.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

