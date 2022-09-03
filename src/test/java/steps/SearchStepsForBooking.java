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
import pages.BookingSearchResultsPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;


public class SearchStepsForBooking {

    private WebDriver driver;
    private BookingSearchPage bookingSearchPage;
    private BookingSearchResultsPage bookingSearchResultsPage;
    private String searchHotelWord;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       bookingSearchPage=new BookingSearchPage(driver);
       bookingSearchResultsPage=new BookingSearchResultsPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @When("I navigate to booking.com")
    public void iNavigateToBookingCom() {

        bookingSearchPage.openBrowser();
    }
    @Given("Word for search is {string}")
    public void wordForSearchIs(String arg0) {
        this.searchHotelWord = arg0;
    }
    @And("I enter search word")
    public void iEnterSearchWord() {
        bookingSearchPage.setHotelsInputValue(searchHotelWord);
    }
    @Given("The rating of this hotel is{double} stars")
    public void ratingIs(double arg0) {
    }
    @And("I press search button")
    public void iPressSearchButton() {
        bookingSearchPage.clickSearchButton();
    }

    @Then("Result contains search word in title")
    public void resultContainsSearchWordInTitle() {
        String resultText = bookingSearchResultsPage.getSearchResultTitle(1);
        boolean doesContains = resultText.toLowerCase().trim().contains(searchHotelWord.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }
    @Then ("The rating of this hotel contains stars")
    public void theRatingOfThisHotelContainsStars(){
        bookingSearchResultsPage.getSearchResultRating(1);

    }
    @Given("this is pre condition")
    public void preCondition() {
        System.out.println("I am pre-condition");
    }

}