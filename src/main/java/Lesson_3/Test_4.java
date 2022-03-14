package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

//Тест 4 "Добавление отзыва к выбранному товару в разделе "Телевизоры Lg"."
public class Test_4 {
    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");//полноэкранный режим
        options.addArguments("--incognito");//режим инкогнито
        options.addArguments("disable-popups-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Подтверждаем свое местоположение
        WebElement webElementButtonTrueLocation = driver.findElement(By.xpath("//div/button[contains(text(), 'Да, верно')]"));
        webElementButtonTrueLocation.click();

        //Нажать на кнопку "Каталог" в хедере сайта.
        WebElement webElementButtonStoreCatalog = driver.findElement(By.xpath("//ul/li/a[contains(text(), 'Каталог')]"));
        webElementButtonStoreCatalog.click();

        //Выбрать "Телевизоры Lg" в разделе "Телевизоры по бренду"
        WebElement webElementBrandTV = driver.findElement(By.xpath("//div/a[@href='/c/televizory/b/LG/']"));
        webElementBrandTV.click();

        //Выбрать первый товар из списка.
        WebElement webElementTV = driver.findElement(By.xpath("//ul/li[@data-product-index='1']/div/a[@data-dy='title']"));
        webElementTV.click();

        //Нажать на кнопку "Отзывы" под изображением товара.
        WebElement webElementTVFeedback = driver.findElement(By.xpath("//li/a[@data-tab='response']"));
        webElementTVFeedback.click();

        //Нажать на кнопку "Написать отзыв"
        WebElement webElementButtonWriteFeedback = driver.findElement(By.xpath("//div[@class='usersReviewsControls']/div/a/span[@class='addReviewRP']"));
        webElementButtonWriteFeedback.click();

        //Заполняем все поля отмеченные "*".
        //Имя
        WebElement webElementNameWriterFeedback = driver.findElement(By.id("responseFio"));
        webElementNameWriterFeedback.click();
        webElementNameWriterFeedback.sendKeys("Tom");
        //Город
        WebElement webElementCityWriterFeedback = driver.findElement(By.id("responseCity"));
        webElementCityWriterFeedback.click();
        webElementCityWriterFeedback.sendKeys("Moscow");
        //Отзыв
        WebElement webElementTextWriterFeedback = driver.findElement(By.id("responseMes"));
        webElementTextWriterFeedback.click();
        webElementTextWriterFeedback.sendKeys("It's a good TV");

        //Нажать на кнопку "Отправить" в нижней части модального окна.
        WebElement webElementButtonSendFeedback = driver.findElement(By.xpath("//div/input[@class='addReviewSubmit']"));
        webElementButtonSendFeedback.click();

        //Закрываем браузер
        driver.quit();
    }
}