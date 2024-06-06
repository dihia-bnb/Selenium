package Data_Driven;

import POM.DprPage;
import POM.HomePage;
import POM.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.util.Properties;

public class FileDriven {
    public WebDriver driver;
    public Properties prop;
    public FileInputStream ip;
   @Test
    public void readFromPropertiesFile() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Data_Driven\\config.Register");
        prop.load(ip);
        register();

    }
    public  void register(){
        driver= new ChromeDriver();
        driver.get(prop.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        homePage.account();
        DprPage ob= new DprPage(driver);
        ob.enterFirstName(prop.getProperty("firstName"));
        ob.enterPhoneNum(prop.getProperty("phoneNumber"));
        ob.password(prop.getProperty("password"));
    }
}
