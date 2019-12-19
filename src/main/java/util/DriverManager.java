package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;


public class DriverManager {
   public static WebDriver driver;
    public static final String USERNAME = "shalinibachu1";
    public static final String AUTOMATE_KEY = "L2sVnkzhS8yJeQUW54qZ";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public DriverManager() throws MalformedURLException {

        String chormeDriverpath = System.getProperty("user.dir") + "/" + "src/main/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chormeDriverpath);
        //driver=new ChromeDriver();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "78.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        driver = new RemoteWebDriver(new URL(URL), caps);*/
        driver.get("https://spree-vapasi-prod.herokuapp.com/");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





    }
}