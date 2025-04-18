package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "userdata")
    public void testLogin(String uname, String pwd) throws InterruptedException {
        BookStorePage bookStorePage = new BookStorePage(driver);
        bookStorePage.clickLogin();
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(uname,pwd);

    }

    @DataProvider(name = "userdata")
    public Object[][] getuserdata(){
        return ExcelUtils.getTestData("src/test/java/testdata/userdata.xlsx","Login");
    }
}
