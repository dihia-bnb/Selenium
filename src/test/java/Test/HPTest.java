package Test;

import POM.HomePage;
import POM.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HPTest  {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://amazon.in");

    }

    @Test  (priority = 1)
    public void goToRegisterPage(){
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.account();
    }
    @Test (priority = 2)
    public void registerPage(){
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.account();
        RegisterPage registerPage= new RegisterPage(driver);
        registerPage.enterFirstName();
        registerPage.enterPhoneNum();
        registerPage.password();
    }


    @AfterMethod
    public void tearDwon(){
       // driver.close();
    }
}
