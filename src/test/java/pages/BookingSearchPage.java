package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookingSearchPage extends BasePage{

    private final static By HOTELS_INPUT= By.cssSelector("//input[@placeholder='Where are you going?']");
    private final static By SEARCH_BUTTON=By.xpath("//button[@type='submit']");

    public BookingSearchPage(WebDriver driver) {

        super(driver);
    }

    public void openBrowser() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }
    public void setHotelsInputValue(String value) {
        driver.findElement(HOTELS_INPUT).sendKeys(value);
    }
    public void clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
    }

}
