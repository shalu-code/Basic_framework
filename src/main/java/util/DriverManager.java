package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
     public static WebDriver driver;

     public DriverManager(){

         String chormeDriverpath= System.getProperty("user.dir")+"/"+"src/main/resources/drivers/chromedriver";
         System.setProperty("webdriver.chrome.driver", chormeDriverpath);
         driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



     }
}
