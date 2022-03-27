package Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class ContactsPage extends AbstractPage{

    @FindBy(id = "contact_us_feedback_name_id")
    private WebElement fieldFirstName;

    @FindBy(id = "contact_us_feedback_lastname_id")
    private WebElement fieldLastName;

    @FindBy(id = "contact_us_feedback_city_id")
    private WebElement fieldCity;

    @FindBy(id = "contact_us_feedback_email_id")
    private WebElement fieldEmail;

    @FindBy(id = "cuselFrame-form_dropdown_feedback_categ")
    private WebElement fieldCategoryOfFeedback;

    @FindBy(xpath = "//div/span[contains(text(),'Консультация по заказу')]")
    private WebElement firstCategory;

    @FindBy(xpath = "//div/textarea[@class='default_textarea required']")
    private WebElement fieldMessage;

    @FindBy(xpath = "//div/input[@class='feedbackFormSubmit']")
    private WebElement buttonSubmitFeedback;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void sentFeedback(String firstName, String LastName, String city, String email, String message){
        Actions feedback=new Actions(getDriver());
        feedback.click(this.fieldFirstName)
                .sendKeys(this.fieldFirstName, "Тест")
                .click(this.fieldLastName)
                .sendKeys(this.fieldLastName, "Тестов")
                .click(this.fieldCity)
                .sendKeys(this.fieldCity, "Москва")
                .click(this.fieldEmail)
                .sendKeys(this.fieldEmail, "Test000@gmail.com")
                .click(this.fieldCategoryOfFeedback)
                .click(this.firstCategory)
                .click(this.fieldMessage)
                .sendKeys(this.fieldMessage, "Don't worry, be happy")
                .click(this.buttonSubmitFeedback)
                .build()
                .perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='new-popup__modal']")));
    }
}
