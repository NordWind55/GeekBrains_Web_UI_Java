package Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage{

    @FindBy(xpath="//header/div/div/div/button")
    private WebElement buttonLogin;

    @FindBy(xpath="//header/div/button")
    private WebElement buttonLocation;

    @FindBy(xpath="//div/input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath="//form[@id='search-form']/div/button[@type='submit']")
    private WebElement buttonSearchSubmit;

    @FindBy(xpath="//header/div/a[@href='/personal/basket.php']")
    private WebElement buttonBasket;

    @FindBy(xpath="//ul/li/a[contains(text(), 'Каталог')]")
    private WebElement buttonCatalog;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm(){
        this.buttonLogin.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/span[contains(text(),'Вход или регистрация')]")));
    }

    public void openLocationForm(){
        this.buttonLocation.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/span[contains(text(),'Выберите ваш город')]")));
    }

    public MainPage fillSearchField(String typeOfGoods){
        this.searchField.click();
        this.searchField.sendKeys("Смартфоны");
        return this;
    }

    public void submitSearch(){
        this.buttonSearchSubmit.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[contains(text(), 'Результаты поиска')]")));
    }

    public void goToBasket(){
        this.buttonBasket.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .urlContains("https://www.eldorado.ru/personal/basket.php"));
    }

    public void goToCatalog(){
        this.buttonCatalog.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li/span[@property='name']")));
    }
}
