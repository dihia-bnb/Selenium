package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DprPage {

    public WebDriver driver;

    public DprPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ap_customer_name")
    private WebElement firstName;

    @FindBy(id = "ap_phone_number")
    private WebElement phone;

    @FindBy(id = "ap_password")
    private WebElement password;

    public void enterFirstName(String name) {

        firstName.sendKeys(name);
    }

    public void enterPhoneNum(String name) {

        phone.sendKeys(name);
    }

    public void password(String name){

        password.sendKeys(name);
    }
}
