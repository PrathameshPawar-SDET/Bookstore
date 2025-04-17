package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BookStorePage extends BasePage{

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(css = ".rt-tbody .rt-tr-group")
    List<WebElement> books;

    @FindBy(css = ".action-buttons span")
    List<WebElement> booksTitle;

    public BookStorePage(WebDriver driver){
        super(driver);
    }

    public void clickLogin(){
        waitForVisibility(loginButton);
        loginButton.click();
    }

    public void searchBook(String bookname){
        waitForVisibility(searchBox);
        searchBox.clear();
        searchBox.sendKeys(bookname);
    }

    public boolean isbookDiplayed(String bookname){
            wait.until(ExpectedConditions.visibilityOfAllElements(books));
            return booksTitle.stream().anyMatch(title -> title.getText().toLowerCase().contains(bookname.toLowerCase()));

    }


}
