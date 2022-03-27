package Lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyLoginTest extends MyAbstractTest{

    //Тест 1 "Авторизация пользователя на сайте"
    @Test
    public void unitTest_1(){
        new MainPage(getDriver()).openLoginForm();
        new LoginPage(getDriver()).clickEnterByEmail();
        Assertions.assertEquals("Вход", getDriver().findElement(By.xpath("//div/form/span[contains(text(),'Вход')]")).getText());
        new LoginPage(getDriver()).setLogin("wish_test@mail.ru").setPassword("w!CXfTf5Mm$$P_R").loginIn();
        Assertions.assertEquals("Алексей,", getDriver().findElement(By.xpath("//header/div/div/div/a/span[contains(text(),'Алексей, ')]")).getText());

    }
}
