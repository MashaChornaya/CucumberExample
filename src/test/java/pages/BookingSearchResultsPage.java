package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchResultsPage extends BasePage{

    private final static By SEARCH_RESULT_NAME= By.xpath("//div[@class='fcab3ed991 a23c043802' and text()]");

    private final static By SEARCH_RESULT_RATING=By.xpath("//div[@class='b5cd09854e d10a6220b4' and text()]");
    public BookingSearchResultsPage(WebDriver driver) {
        super(driver);
    }

   // public String getSearchResultTitle() {
     //   return driver.findElement(SEARCH_RESULT_NAME).getText();

    //}
    public String getSearchResultTitle(int index){
        return driver.findElements(SEARCH_RESULT_NAME).get(index -1).getText();
    }
    public String getSearchResultRating(int rating){
        return driver.findElements(SEARCH_RESULT_RATING).get(rating -1).getText();
    }
}
