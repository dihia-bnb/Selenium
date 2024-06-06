package M.common;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Utility {
	public static WebDriver driver;
	 @Parameters({"browsers"})
	@BeforeClass
	  public void beforeClass(String window) throws InterruptedException {
	String windows =System.getProperty("user.dir");
	System.out.println(windows);
		 
		if(window.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
			driver.navigate().to("Https://www.facebook.com");
			driver.manage().window().maximize();
			Thread.sleep(6000);
			
		  }else if(window.equalsIgnoreCase("Edge")) {

			driver= new EdgeDriver();
			driver.navigate().to("Https://www.facebook.com");
			driver.manage().window().maximize();
			Thread.sleep(6000);
		  }else if(window.equalsIgnoreCase("Firefox")) {

			    driver= new FirefoxDriver();
				driver.navigate().to("Https://www.facebook.com");
				driver.manage().window().maximize();
				Thread.sleep(6000);
			  
		  }
		  
	  }
	 @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
    
	  
	// This for take screen shot
	  
	  public void Pictures() throws IOException {
		  Date dt=new Date();
		  String sk=dt.toString().replace(" ", "_").replace(":", "_");
		  System.out.println(sk);
		  System.out.println(dt);
		  String windows =System.getProperty("user.dir");
		  File screenshorts= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(screenshorts,  new File(windows+"\\Pivtures\\"+sk+"ShotOfPage.jpg"));
	  }
	  
	  
} 
