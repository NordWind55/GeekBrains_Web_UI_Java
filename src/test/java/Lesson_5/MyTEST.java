package Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTEST extends MyAbstractTest {

    //Тест 1 "Авторизация пользователя на сайте"
    @Test
    public void unitTest_1(){
        //Нажать на кнопку "Вход или регистрация" в хедере сайта.
        getDriver().findElement(By.xpath("//header/div/div/div/button")).click();
        //Ожидание
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/span[contains(text(),'Вход или регистрация')]")));

        //Нажать на кнопку "Вход по e-mail/логину" в модальном окне.
        getDriver().findElement(By.xpath("//form/button[contains(text(), 'Вход по e-mail/логину')]")).click();

        Actions actions = new Actions(getDriver());
        //1-Ввести адрес электронной почты в поле "E-mail или логин".
        //2-Ввести пароль в поле "Пароль".
        //3-Нажать на кнопку "Войти"
        //4-Закрываем всплывающее окно "Подтвердите ваш E-mail"
        actions.sendKeys(getDriver().findElement(By.xpath("//*[@name='login']")),"wish_test@mail.ru")
                .click(getDriver().findElement(By.xpath("//*[@name='password']")))
                .sendKeys("w!CXfTf5Mm$$P_R")
                .click(getDriver().findElement(By.xpath("//form/button[@type='submit']")))
                //.click(getDriver().findElement(By.xpath("//button[@aria-label='Закрыть']")))
                .build()
                .perform();

        //Проверяем тест 1
        Assertions.assertEquals("Алексей,", getDriver().findElement(By.xpath("//header/div/div/div/a/span[contains(text(),'Алексей, ')]")).getText());
    }

    //Тест 2 "Изменение геолокации на сайте перед совершением покупки"
    @Test
    public void unitTest_2(){

        //Нажать на кнопку выбора местоположения в левой части хедера сайта.
        getDriver().findElement(By.xpath("//header/div/button")).click();

        Actions actions = new Actions(getDriver());
        //Ввести название города в поле "Начните вводить ваш город"
        actions.click(getDriver().findElement(By.xpath("//div/input[@name='region-search']")))
                .sendKeys("Сургут")
                .build()
                .perform();

        //Выбрать город, предложенный сайтом.
        getDriver().findElement(By.id("region-search-list-box")).click();
        //Проверяем тест 2
        Assertions.assertTrue(getDriver().findElement(By.xpath("//header/div/button/span[contains(text(),'Сургут. Ханты-Мансийский АО')]"))
                .getText().equals("Сургут. Ханты-Мансийский АО"));
    }

    //Тест 3 "Поиск и добавление товара в корзину"
    @Test
    public void unitTest_3(){

        Actions actions=new Actions(getDriver());
        //Ввести название товара в строку поиска.
        //Нажать на кнопку "Найти" справа от строки поиска.(либо кнопку "Enter")
        actions.click(getDriver().findElement(By.xpath("//div/input[@name='search']")))
                .sendKeys("Смартфоны")
                .click(getDriver().findElement(By.xpath("//form[@id='search-form']/div/button[@type='submit']")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//div/h1[contains(text(), 'Результаты поиска')]"))
                .getText().equals("Результаты поиска"),"Что-то пошло не так");

        //Нажать на кнопку "Добавить в корзину" напротив любого товара из списка.
        getDriver().findElement(By.xpath("//span[contains(text(),'Добавить в корзину')]")).click();

        //Записать наименование выбранного товара в переменную
        String checkTitle=getDriver().findElement(By.xpath("//span[contains(text(),'В корзине')]/../../../../div/a[@data-dy='title']")).getText();

        //Явное ожидание появления товаров в корзине
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//header/div/a[@href='/personal/basket.php']/span/span[@data-dy='header-cart-counter']")));

        //Нажать на кнопку "Корзина" в хедере сайта.
        getDriver().findElement(By.xpath("//header/div/a[@href='/personal/basket.php']")).click();

        //Сравнить наименование выбранного товара с наименованием товара в корзине.
        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@id='cart-items']/div/div/div/a[@data-xid]"))
                .getText().equals(checkTitle), "Название товаров не совпадает");
    }

    //Тест 4 "Добавление отзыва к выбранному товару в разделе "Телевизоры Lg"."
    @Test
    public void unitTest_4(){

        //Нажать на кнопку "Каталог" в хедере сайта.
        getDriver().findElement(By.xpath("//ul/li/a[contains(text(), 'Каталог')]")).click();
        //Ожидание
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/span[@property='name']")));
        //Проверка перехода
        Assertions.assertEquals("https://www.eldorado.ru/d/",getDriver().getCurrentUrl());

        //Выбрать "Телевизоры Lg" в разделе "Телевизоры по бренду"
        getDriver().findElement(By.xpath("//div/a[@href='/c/televizory/b/LG/']")).click();
        //Ожидание
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[@data-pc='cat_name']")));
        //Проверка перехода
        Assertions.assertEquals("https://www.eldorado.ru/c/televizory/b/LG/",getDriver().getCurrentUrl());

        //Выбрать первый товар из списка.
        String selectedItem = getDriver().findElement(By.xpath("//ul/li[@data-product-index='1']/div/a[@data-dy='title']")).getText();
        getDriver().findElement(By.xpath("//ul/li[@data-product-index='1']/div/a[@data-dy='title']")).click();
        //Проверка перехода
        Assertions.assertEquals(getDriver().findElement(By.xpath("//div[@id='productTopPanel']/div/div/div/h1")).getText(),selectedItem);

        //Нажать на кнопку "Отзывы" под изображением товара.
        getDriver().findElement(By.xpath("//li/a[@data-tab='response']")).click();
        //Проверка перехода к отзывам о товаре
        Assertions.assertEquals(getDriver().findElement(By.xpath("//li[@class='active']/a")).getText(),"Отзывы");

        //Нажать на кнопку "Написать отзыв"
        getDriver().findElement(By.xpath("//div[@class='usersReviewsControls']/div/a/span[@class='addReviewRP']")).click();

        Actions actions=new Actions(getDriver());
        //Заполняем все поля отмеченные "*".
        //Имя
        //Город
        //Отзыв
        //Нажать на кнопку "Отправить" в нижней части модального окна.
        actions.click(getDriver().findElement(By.id("responseFio")))
                .sendKeys("Tom")
                .click(getDriver().findElement(By.id("responseCity")))
                .sendKeys("Moscow")
                .click(getDriver().findElement(By.id("responseMes")))
                .sendKeys("It's a good TV")
                .click(getDriver().findElement(By.xpath("//div/input[@class='addReviewSubmit']")))
                .build()
                .perform();

        //Явное ожидание элемента
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='message-to-client __thanks-to-client']")));

        //Проверяем тест 4
        Assertions.assertEquals(getDriver().findElement(By.xpath("//div/div[@class='thanks-to-client__title']"))
                .getText(),"Большое спасибо за Ваш отзыв!");
    }

    //Тест 5 "Заполнение формы обратной связи и отправка сообщения."
    @Test
    public void unitTest_5(){
        //Ждем появления элемента
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[contains(text(),'Через сайт')]")));

        //Нажать на кнопку "Контакты" в подвале.
        getDriver().findElement(By.xpath("//div/a[contains(text(),'Через сайт')]")).click();
        //getDriver().findElement(By.xpath("//div/a[contains(text(),'Через сайт')]")).click();

        //Ждем появления элемента
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mainLeft']")));

        //Заполняем все поля со звездочками.
        Actions actions=new Actions(getDriver());
        actions.click(getDriver().findElement(By.id("contact_us_feedback_name_id")))
                .sendKeys("Тест")
                .click(getDriver().findElement(By.id("contact_us_feedback_lastname_id")))
                .sendKeys("Тестов")
                .click(getDriver().findElement(By.id("contact_us_feedback_city_id")))
                .sendKeys("Москва")
                .click(getDriver().findElement(By.id("contact_us_feedback_email_id")))
                .sendKeys("Test000@gmail.com")
                .click(getDriver().findElement(By.id("cuselFrame-form_dropdown_feedback_categ")))
                .click(getDriver().findElement(By.xpath("//div/span[contains(text(),'Консультация по заказу')]")))
                .click(getDriver().findElement(By.xpath("//div/textarea[@class='default_textarea required']")))
                .sendKeys("Don't worry, be happy")
                .click(getDriver().findElement(By.xpath("//div/input[@class='feedbackFormSubmit']")))
                .build()
                .perform();

        //Проверяем тест 5
        Assertions.assertEquals(getDriver().findElement(By.xpath("//div/div/div/div/span[@class='new-popup__title']"))
                .getText(),"Обращение принято");
    }

    //Тест 6 "Изменение количества единиц товара в корзине и покупка выбранного товара"
    @Test
    public void unitTest_6(){
        Actions actionsFindProduct=new Actions(getDriver());
        //Ввести название товара в строку поиска.
        //Нажать на кнопку "Найти" справа от строки поиска.(либо кнопку "Enter")
        actionsFindProduct.click(getDriver().findElement(By.xpath("//div/input[@name='search']")))
                .sendKeys("Телевизоры")
                .click(getDriver().findElement(By.xpath("//form[@id='search-form']/div/button[@type='submit']")))
                .build()
                .perform();

        //Нажать на кнопку "Добавить в корзину" напротив любого товара из списка.
        getDriver().findElement(By.xpath("//span[contains(text(),'Добавить в корзину')]")).click();

        //Явное ожидание появления товаров в корзине
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//header/div/a[@href='/personal/basket.php']/span/span[@data-dy='header-cart-counter']")));

        //Нажать на кнопку "Корзина" в хедере сайта.
        getDriver().findElement(By.xpath("//header/div/a[@href='/personal/basket.php']")).click();

        //Нажать на кнопку "+" в столбце "Количество".
        getDriver().findElement(By.xpath("//div[@class='qs-side-right']")).click();

        //Выбрать город в поле "Выберите город" под кнопкой  "Самовывоз".
        getDriver().findElement(By.xpath("//div[@class='cuselText']")).click();
        getDriver().findElement(By.xpath("//div[@class='cusel-scroll-wrap']/div/div/span[contains(text(), 'Москва')]")).click();

        //Нажать на кнопку "Продолжить" внизу раздела "Итого".
        getDriver().findElement(By.xpath("//div[@class='cartTotalPartIndent q-cartTotalPartIndent']/a/span")).click();

        //Выбрать пункт самовывоза в разделе "Магазины «Эльдорадо»"
        getDriver().findElement(By.xpath("//a[@class='pickupListAdres']")).click();

        //Нажать на кнопку "Заберу отсюда"
        getDriver().findElement(By.xpath("//div/input[@data-type='delivery']")).click();

        //Нажать на кнопку "Продолжить" внизу раздела "Ваш заказ"
        getDriver().findElement(By.xpath("//span/input[@value='Продолжить']")).click();

        //Проверяем тест 6
        Assertions.assertTrue(getDriver().getCurrentUrl()
                .equals("https://www.eldorado.ru/personal/order.php?step=order_confirm"),"страница недоступна");
    }
}