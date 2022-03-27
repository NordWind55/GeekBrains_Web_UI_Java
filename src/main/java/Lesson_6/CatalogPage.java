package Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage extends AbstractPage{

    @FindBy(xpath="//div/a[@href='/c/televizory/b/LG/']")
    private WebElement brandTV;

    @FindBy(xpath="//ul/li[@data-product-index='1']/div/a[@data-dy='title']")
    private WebElement firstRandomTV;

    @FindBy(xpath="//li/a[@data-tab='response']")
    private WebElement buttonFeedback;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void goToTVBrand(){
        this.brandTV.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@data-pc='cat_name']")));
    }

    public void goToFirstRandomTV(){
        this.firstRandomTV.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='productTopPanel']/div/div/div/h1")));
    }

    public void goToFeedback(){
        this.buttonFeedback.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='usersReviewsControls']/div/a/span[@class='addReviewRP']")));
    }
}
