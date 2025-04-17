package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
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
        super(driver);
    }

    public void register(String firstName, String lastName, String userName, String Password) throws InterruptedException{
        waitForVisibility(firstNameInput);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(Password);

        System.out.println("Solve Captca manually...");
        Thread.sleep(10000);
        registerButton.click();

    }
}
