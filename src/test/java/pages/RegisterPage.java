package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "userName")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "register")
    WebElement registerButton;

    @FindBy(id = "gotologin")
    WebElement backToLogin;


    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void register(String firstName, String lastName, String userName, String Password){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(Password);

    }
}
