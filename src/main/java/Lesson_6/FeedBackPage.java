package Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeedBackPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='usersReviewsControls']/div/a/span[@class='addReviewRP']")
    private WebElement buttonWriteFeedback;

    @FindBy(id = "responseFio")
    private WebElement fieldName;

    @FindBy(id = "responseCity")
    private WebElement fieldCityName;

    @FindBy(id = "responseMes")
    private WebElement fieldMessage;

    @FindBy(xpath = "//div/input[@class='addReviewSubmit']")
    private WebElement buttonFeedbackSubmit;

    public FeedBackPage(WebDriver driver) {
        super(driver);
    }

    public void goToWriteFeedback(){
        this.buttonWriteFeedback.click();
    }

    public void writeFeedback(String name, String cityName, String message){
        Actions review=new Actions(getDriver());
        review.click(this.fieldName)
                .sendKeys(this.fieldName, name)
                .click(this.fieldCityName)
                .sendKeys(this.fieldCityName, cityName)
                .click(this.fieldMessage)
                .sendKeys(this.fieldMessage, message)
                .click(this.buttonFeedbackSubmit)
                .build()
                .perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='message-to-client __thanks-to-client']")));
    }
}
