package automation_login;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class StepDefinitions
{
    WebDriver driver;
    String browser = "Chrome";
    String baseURL = "http://automationpractice.com";
    @Before
    //start browser
    public void startBrowser() {
        if ( browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void stopBrowser()
    {

        driver.quit();
    }
    @Given("^I am on Signin page$")
    public void i_am_on_signin_page() throws Throwable {
        System.out.println(" i am on sign in");
        Assert.assertTrue(driver.findElement(By.cssSelector("a.login")).isDisplayed());
        driver.findElement(By.cssSelector("a.login")).click();
        throw new PendingException();
    }

    @When("^I enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void i_enters_username_as_something_and_password_as_something(String username, String password) throws Throwable {

        System.out.println(" i enter username ");
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        throw new PendingException();
    }

    @Then("^I should login successfully$")
    public void i_should_login_successfully() throws Throwable {
        System.out.println(" login successful");
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
        throw new PendingException();
    }

    @And("^I select Signin button$")
    public void i_select_signin_button() throws Throwable {
        System.out.println(" sign in button");
        driver.findElement(By.id("SubmitLogin")).click();
        throw new PendingException();
    }

    @And("^I should see welcome message as \"([^\"]*)\"$")
    public void i_should_see_welcome_message_as_something(String welcomeMessage) throws Throwable {
        System.out.println(" welcome message");
        Assert.assertTrue(driver.findElement(By.className("info-account")).getText().equals(welcomeMessage));
        throw new PendingException();
    }


// invalid credentials
 /*   @Then("^I should see failed login error message $")
    public void verifyInvalidLoginErrorMessage() {
*/
    }









