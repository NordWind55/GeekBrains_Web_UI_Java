package Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage extends AbstractPage{

    @FindBy(xpath="//div/input[@name='region-search']")
    private WebElement fieldLocation;

    @FindBy(id="region-search-list-box")
    private WebElement foundPlace;

    public LocationPage(WebDriver driver) {
        super(driver);
    }

    public LocationPage setLocation(String location){
        this.fieldLocation.click();
        this.fieldLocation.sendKeys(location);
        return this;
    }

    public void chooseFoundPlace(){
        this.foundPlace.click();
    }
}
