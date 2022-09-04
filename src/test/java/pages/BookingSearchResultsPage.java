package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchResultsPage extends BasePage{

    private final static By SEARCH_RESULT_NAME= By.xpath("//div[@data-testid='title' and text()]");

    private final static By SEARCH_RESULT_RATING=By.xpath("//div[@data-testid='review-score']//div[@aria-label and text()]");
    public BookingSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitle(int index){
        return driver.findElements(SEARCH_RESULT_NAME).get(index -1).getText();
    }
    public String getSearchResultRating(int rating){
        return driver.findElements(SEARCH_RESULT_RATING).get(rating -1).getText();
    }
}
