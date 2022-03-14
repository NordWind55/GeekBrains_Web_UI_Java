package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//Тест 3 "Поиск и добавление товара в корзину"
public class Test_3 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");//полноэкранный режим
        options.addArguments("--incognito");//режим инкогнито
        options.addArguments("disable-popups-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Подтверждаем свое местоположение
        WebElement webElementButtonTrueLocation = driver.findElement(By.xpath("//div/button[contains(text(), 'Да, верно')]"));
        webElementButtonTrueLocation.click();

        //Ввести название товара в строку поиска.
        WebElement webElementFieldFindProduct = driver.findElement(By.xpath("//div/input[@name='search']"));
        webElementFieldFindProduct.click();
        webElementFieldFindProduct.sendKeys("Смартфоны");
        //Нажать на кнопку "Найти" справа от строки поиска.(либо кнопку "Enter")
        webElementFieldFindProduct.submit();

        //Нажать на кнопку "Добавить в корзину" напротив любого товара из списка. (//ul/li[@data-product-index='1']/div/div/button/span[@data-dy='buttonText'])
        WebElement webElementAddToBasket_1 = driver.findElement(By.xpath("//span[contains(text(),'Добавить в корзину')]"));
        webElementAddToBasket_1.click();
        //Добавить второй товор в корзину
        WebElement webElementAddToBasket_2 = driver.findElement(By.xpath("//span[contains(text(),'Добавить в корзину')]"));
        webElementAddToBasket_2.click();

        //Явное ожидание появления товаров в корзине
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//header/div/a[@href='/personal/basket.php']/span/span[@data-dy='header-cart-counter']")));

        //Нажать на кнопку "Корзина" в хедере сайта.
        WebElement webElementButtonGoToBasket = driver.findElement(By.xpath("//header/div/a[@href='/personal/basket.php']"));
        webElementButtonGoToBasket.click();

        //Удаление товаров из корзины
//        WebElement webElementCleanBasket = driver.findElement(By.xpath("//div/span[@class='q-basketBlockRowHeaderItem__clearBasketBtn']"));
//        webElementCleanBasket.click();

        //Закрываем браузер
        driver.quit();
    }
}