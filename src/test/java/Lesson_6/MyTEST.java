package Lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyTEST extends MyAbstractTest {

    //Тест 2 "Изменение геолокации на сайте перед совершением покупки"
    @Test
    public void unitTest_2(){
        new MainPage(getDriver()).openLocationForm();
        Assertions.assertEquals("Выберите ваш город", getDriver()
                .findElement(By.xpath("//div/span[contains(text(),'Выберите ваш город')]")).getText());
        new LocationPage(getDriver()).setLocation("Сургут");
        new LocationPage(getDriver()).chooseFoundPlace();
        Assertions.assertEquals("Сургут. Ханты-Мансийский АО",getDriver()
                .findElement(By.xpath("//header/div/button/span[contains(text(),'Сургут. Ханты-Мансийский АО')]")).getText());
    }

    //Тест 3 "Поиск и добавление товара в корзину"
    @Test
    public void unitTest_3(){
        new MainPage(getDriver()).fillSearchField("Смартфоны");
        new MainPage(getDriver()).submitSearch();
        new FoundGoodsPage(getDriver()).addToBasket();
        new MainPage(getDriver()).goToBasket();
        Assertions.assertEquals(new FoundGoodsPage(getDriver()).rememberChoseGoods(),getDriver()
                .findElement(By.xpath("//div[@id='cart-items']/div/div/div/a[@data-xid]")));
    }

    //Тест 4 "Добавление отзыва к выбранному товару в разделе "Телевизоры Lg"."
    @Test
    public void unitTest_4(){
        new MainPage(getDriver()).goToCatalog();
        Assertions.assertEquals("https://www.eldorado.ru/d/",getDriver().getCurrentUrl());
        new CatalogPage(getDriver()).goToTVBrand();
        Assertions.assertEquals("https://www.eldorado.ru/c/televizory/b/LG/",getDriver().getCurrentUrl());
        new CatalogPage(getDriver()).goToFirstRandomTV();
        new CatalogPage(getDriver()).goToFeedback();
        Assertions.assertEquals(getDriver().findElement(By.xpath("//li[@class='active']/a")).getText(),"Отзывы");
        new FeedBackPage(getDriver()).goToWriteFeedback();
        new FeedBackPage(getDriver()).writeFeedback("Tom","Moscow","It's a good TV");
        Assertions.assertEquals(getDriver().findElement(By.xpath("//div/div[@class='thanks-to-client__title']"))
                .getText(),"Большое спасибо за Ваш отзыв!");
    }

    //Тест 5 "Заполнение формы обратной связи и отправка сообщения."
    @Test
    public void unitTest_5(){
        new FooterMainPage(getDriver()).goToContacts();
        new ContactsPage(getDriver()).sentFeedback("Тест","Тестов","Москва","Test000@gmail.com","Don't worry, be happy");
        Assertions.assertEquals(getDriver().findElement(By.xpath("//div/div/div/div/span[@class='new-popup__title']"))
                .getText(),"Обращение принято");
    }

    //Тест 6 "Проверка перехода по ссылкам в разделе "Покупателю" в подвале сайта.
    @Test
    public void unitTest_6(){
        new FooterMainPage(getDriver()).moveDownToFooter();
        new FooterMainPage(getDriver()).goToHowToRegister();
        Assertions.assertEquals("https://www.eldorado.ru/help/registration/howToRegister.php", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToHowToOrder();
        Assertions.assertEquals("https://www.eldorado.ru/help/order_steps.php", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToPay();
        Assertions.assertEquals("https://www.eldorado.ru/help/pay/", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToDelivery();
        Assertions.assertEquals("https://www.eldorado.ru/help/delivery/", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToPickUp();
        Assertions.assertEquals("https://www.eldorado.ru/help/pickup.php", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToService();
        Assertions.assertEquals("https://www.eldorado.ru/help/service.php", getDriver().getCurrentUrl());
        new FooterMainPage(getDriver()).goToMainPage();
        new FooterMainPage(getDriver()).goToExchangeReturn();
        Assertions.assertEquals("https://www.eldorado.ru/help/obmen_vozvrat.php", getDriver().getCurrentUrl());
    }

}
