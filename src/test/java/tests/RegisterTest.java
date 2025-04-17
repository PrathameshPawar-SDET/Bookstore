package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ExcelUtils;

public class RegisterTest extends BaseTest {


    @Test(dataProvider = "userdata")
    public void testUserRegistration(String fname, String lname, String uname, String pwd) throws InterruptedException {
        BookStorePage bookStorePage = new BookStorePage(driver);
        bookStorePage.clickLogin();
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.newUser();
        Thread.sleep(5000);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(fname,lname,uname,pwd);
        Thread.sleep(5000);
        registerPage.alert();
    }

    @DataProvider(name = "userdata")
    public Object[][] getuserData(){
        return ExcelUtils.getTestData("src/test/java/testdata/userdata.xlsx","Register");
    }
}
