package suite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.ConfigFileReader;
import util.DriverManager;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SuiteManager {

    DriverManager driverManager;
    private static ConfigFileReader config=new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver() throws MalformedURLException {

        //driverManager=new DriverManager();
        driverManager =new DriverManager();

    }

  /* @AfterSuite(alwaysRun = true)
    public void quitDriver() {


        driverManager.driver.quit();
   }*/
   //@BeforeClass
   public void launchUrl() {

        DriverManager.driver.manage().window().maximize();

        String baseUrl=config.getProperty("base_Url");
        DriverManager.driver.get(baseUrl);
       WebDriverWait wait= new WebDriverWait(DriverManager.driver,30);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#link-to-login")));

   }


}
