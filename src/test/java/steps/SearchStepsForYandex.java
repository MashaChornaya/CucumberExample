package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.YandexSearchResultsPage;
import pages.YandexSearchPage;

import java.util.concurrent.TimeUnit;


public class SearchStepsForYandex {
    private WebDriver driver;
    private YandexSearchPage yandexSearchPage;
    private YandexSearchResultsPage yandexSearchResultsPage;
    private String searchWord;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        yandexSearchPage = new YandexSearchPage(driver);
        yandexSearchResultsPage = new YandexSearchResultsPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @When("I navigate to yandex.by")
    public void iNavigateToYandexBy() {
        yandexSearchPage.open();
    }
    @Given("Word for search is it {string}")
    public void wordForSearchIsIt(String arg0) {
        this.searchWord = arg0;
    }

    @And("I enter my search word")
    public void iEnterMySearchWord() {
        yandexSearchPage.setSearchInputValue(searchWord);
    }

    @And("I press my search button")
    public void iPressMySearchButton() {
        yandexSearchPage.clickSearchButton();
    }

    @Then("First result contains my search word in title")
    public void firstResultContainsSearchWordInTitle() {
        String firstResultText = yandexSearchResultsPage.getSearchResultTitleByIndex(1);
        boolean doesContains = firstResultText.toLowerCase().trim().contains(searchWord.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }

    @Then("There are {int} results are present")
    public void thereAreResultsArePresent(int arg0) {
        Assert.assertEquals(yandexSearchResultsPage.getSearchResultsCount(), arg0);
    }


    @Given("pre condition")
    public void preCondition() {
        System.out.println("I am pre-condition");
    }
}
