package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ap_customer_name")
    private WebElement firstName;

    @FindBy(id = "ap_phone_number")
    private WebElement phone;

    @FindBy(id = "ap_password")
    private WebElement password;

    public void enterFirstName() {
        firstName.sendKeys("faouzi");

    }

    public void enterPhoneNum() {
        phone.sendKeys("1254789632");
    }

    public void password(){
        password.sendKeys("Mimiche01@");
    }

}
