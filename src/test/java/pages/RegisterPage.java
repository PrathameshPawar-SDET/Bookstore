package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage extends BasePage {

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
        scrollintoview(firstNameInput);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(Password);

        System.out.println("Solve Captca manually...");
        Thread.sleep(10000);
        registerButton.click();

    }

    public void alert(){
       try {
           Alert alert = driver.switchTo().alert();
           String alerttext = alert.getText();
           Assert.assertTrue(alerttext.contains("User Register Successfully"));
           System.out.println("Registration completed successfully");
           alert.accept();
       }
       catch (NoAlertPresentException e){
           System.out.println("No alert present");
           Assert.fail("Expected registration alert not found");
       }
    }
}
