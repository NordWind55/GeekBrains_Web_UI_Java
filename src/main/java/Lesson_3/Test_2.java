package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

//Тест 2 "Изменение геолокации на сайте перед совершением покупки"
public class Test_2 {
    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");//полноэкранный режим
        options.addArguments("--incognito");//режим инкогнито
        options.addArguments("disable-popups-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Нажать на кнопку выбора местоположения в левой части хедера сайта.
        WebElement webElementButtonLocation = driver.findElement(By.xpath("//header/div/button"));
        webElementButtonLocation.click();

        //Ввести название города в поле "Начните вводить ваш город"
        WebElement webElementFieldEnterCity = driver.findElement(By.xpath("//div/input[@name='region-search']"));
        webElementFieldEnterCity.click();
        webElementFieldEnterCity.sendKeys("Сургут");

        //Выбрать город, предложенный сайтом.
        WebElement webElementFoundCity = driver.findElement(By.id("region-search-list-box"));
        webElementFoundCity.click();

        //Закрываем браузер
        driver.quit();

    }
}