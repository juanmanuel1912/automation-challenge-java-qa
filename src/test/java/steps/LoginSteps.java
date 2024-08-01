package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        loginPage.login("invalid_user", "wrong_password");
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        assert homePage.isDisplayed();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assert loginPage.isErrorMessageDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
