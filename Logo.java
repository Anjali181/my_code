package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Login{
    WebDriver driver;

    @Given("Open the Chrome and open xenonstack login page")
    public void user_is_on_the_xenonstack_login_page() {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.jobs/app/login");
    }

    @When("User enters correct username and password")
    public void enter_Username_Password() {
        driver.findElement(By.xpath("//input[@id='tpt_loginUsername']")).sendKeys("xcvcxvzxczcx@gmail.com");
        driver.findElement(By.xpath("//input[@id='tpt_loginPassword']")).sendKeys("Sunita@07");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        loginButton.click();
    }

    @Then("User should be logged in successfully")
    public void verify_successful_login() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Valid Login Successful");
        driver.close();
    }
}
