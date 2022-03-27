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

public class FooterMainPage extends AbstractPage{

    @FindBy(xpath="//div/a[contains(text(),'Через сайт')]")
    private WebElement buttonContacts;

    @FindBy(xpath="//li/a[@href='/help/registration/howToRegister.php']")
    private WebElement linkHowToRegister;

    @FindBy(xpath="//li/a[@href='/help/order_steps.php']")
    private WebElement linkHowToOrder;

    @FindBy(xpath="//li/a[@href='/help/pay/']")
    private WebElement linkPay;

    @FindBy(xpath="//li/a[@href='/help/delivery/']")
    private WebElement linkDelivery;

    @FindBy(xpath="//li/a[@href='/help/pickup.php']")
    private WebElement linkPickUp;

    @FindBy(xpath="//li/a[@href='/help/service.php']")
    private WebElement linkService;

    @FindBy(xpath="//li/a[@href='/help/obmen_vozvrat.php']")
    private WebElement linkExchangeReturn;

    public FooterMainPage(WebDriver driver) {
        super(driver);
    }

    public void goToContacts(){
        moveDownToFooter();
        this.buttonContacts.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='mainLeft']")));
    }

    public void goToHowToRegister(){
        this.linkHowToRegister.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void goToHowToOrder(){
        this.linkHowToOrder.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void goToPay(){
        this.linkPay.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void goToDelivery(){
        this.linkDelivery.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span/span[@class='sectionLink']")));
    }

    public void goToPickUp(){
        this.linkPickUp.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void goToService(){
        this.linkService.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void goToExchangeReturn(){
        this.linkExchangeReturn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/h1[@class='visible-mobile']")));
    }

    public void moveDownToFooter(){
        Actions moveDown =new Actions(getDriver());
        moveDown
                .sendKeys(Keys.CONTROL, Keys.END)
                .build()
                .perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/a[contains(text(),'Покупателю')]")));
    }

    public void goToMainPage(){
        getDriver().navigate().to("https://www.eldorado.ru/");
        moveDownToFooter();
    }



}
