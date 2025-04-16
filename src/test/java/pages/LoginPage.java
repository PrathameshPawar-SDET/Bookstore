package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

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
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void newUser(){
        newUserButton.click();
    }

    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
