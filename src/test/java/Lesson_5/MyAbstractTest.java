package Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class MyAbstractTest {
    private static WebDriver driver;

    @BeforeEach
    public void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Подтверждаем свое местоположение
        getDriver().findElement(By.xpath("//div/button[contains(text(), 'Да, верно')]")).click();
    }

  //  @BeforeEach
//    void goTo(){
//        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.eldorado.ru/"),
//                "Страница не доступна");
//    }

    @AfterEach
    public void close(){
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
