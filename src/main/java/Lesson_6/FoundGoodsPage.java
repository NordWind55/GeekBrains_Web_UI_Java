package Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FoundGoodsPage extends AbstractPage{

    @FindBy(xpath="//span[contains(text(),'Добавить в корзину')]")
    private WebElement buttonAddToBasket;

    @FindBy(xpath="//span[contains(text(),'В корзине')]/../../../../div/a[@data-dy='title']")
    private WebElement addedGoods;

    public FoundGoodsPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket(){
        this.buttonAddToBasket.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//header/div/a[@href='/personal/basket.php']/span/span[@data-dy='header-cart-counter']")));
    }

    public String rememberChoseGoods(){
        String titleGoods=this.addedGoods.getText();
        return titleGoods;
    }
}
