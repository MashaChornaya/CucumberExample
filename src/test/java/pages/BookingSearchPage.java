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
        driver.get("https://www.booking.com/index.en-gb.html?label=gen173nr-1DCAEoggI46AdIM1gEaCWIAQGYAQm4ARfIAQzYAQPoAQGIAgGoAgO4ApiNzZgGwAIB0gIkY2NiZWFlN2QtZWE1NC00ZDA4LWI3ZGMtYTkwZWUxMWY4NzU02AIE4AIB&sid=1146f3fc77abc3f7b4ebbe7fdec3064f&keep_landing=1&sb_price_type=total&");
    }
    public void setHotelsInputValue(String value) {
        driver.findElement(HOTELS_INPUT).sendKeys(value);
    }
    public void clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
    }

}
