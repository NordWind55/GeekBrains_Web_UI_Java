package Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath="//form/button[contains(text(), 'Вход по e-mail/логину')]")
    private WebElement buttonEnterByEmail;

    @FindBy(xpath="//*[@name='login']")
    private WebElement fieldLogin;

    @FindBy(xpath="//*[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath="//form/button[@type='submit']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickEnterByEmail(){
        this.buttonEnterByEmail.click();
        return this;
    }

    public LoginPage setLogin(String login){
        this.fieldLogin.click();
        this.fieldLogin.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.fieldPassword.click();
        this.fieldPassword.sendKeys(password);
        return this;
    }

    public LoginPage loginIn(){
        this.buttonSubmit.click();
        return this;
    }
}
