package Lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class MyAbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Подтверждаем свое местоположение
        getDriver().findElement(By.xpath("//div/button[contains(text(), 'Да, верно')]")).click();
    }

    @AfterEach
    void goToMainPage(){
        getDriver().navigate().to("https://www.eldorado.ru/");
        Assertions.assertEquals("https://www.eldorado.ru/", getDriver().getCurrentUrl(), "Страница не доступна");
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
