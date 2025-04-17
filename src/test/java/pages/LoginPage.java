package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
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
        super(driver);
    }

    public void newUser(){
        newUserButton.click();
    }

    public void login(String username, String password){
        waitForVisibility(userNameInput);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
