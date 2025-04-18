package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "userName")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "name")
    WebElement errorMessage;

    @FindBy(id = "newUser")
    WebElement newUserButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void newUser(){
        scrollintoview(newUserButton);
        newUserButton.click();
    }

    public void login(String username, String password) throws InterruptedException{
        scrollintoview(userNameInput);
        waitForVisibility(userNameInput);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        Thread.sleep(5000);
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(currenturl,"https://demoqa.com/books", "Login has been failed");
        System.out.println("Login Successfull!!!");
    }
}
