package Data_Driven;

import POM.DprPage;
import POM.HomePage;
import POM.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.in");
        driver.getTitle();
    }
    @Test(priority = 1)
    public void goToRegisterPage(){
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.account();
    }
     @Test(priority = 2, dataProvider = "ARegister", dataProviderClass = ExcelCode.class)
    public void registerPage(String FirstName, String PhoneNumber, String Password){
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.account();
         DprPage ob= new DprPage(driver);
         ob.enterFirstName(FirstName);
         ob.enterPhoneNum(PhoneNumber);
         ob.password(Password);


    }

}
