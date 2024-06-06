package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "nav-link-accountList-nav-line-1")
    private WebElement AccoutList;
    @FindBy (xpath = "(//a[contains(text(),'Start here.')])[1]")
    private  WebElement NewCustomer;

    public void account(){
        Actions ob = new Actions(driver);

      /*  WebElement hovers= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        ob.moveToElement(hovers).build().perform();
        NewCustomer.click();*/

        ob.moveToElement(AccoutList);
        ob.moveToElement(NewCustomer);
        ob.click().build().perform();

    }




}
