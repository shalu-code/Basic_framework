package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManager {

    DriverManager driverManager;
    private static ConfigFileReader config=new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver(){

        driverManager =new DriverManager();

    }

   @AfterSuite(alwaysRun = true)
    public void quitDriver() {

        driverManager.driver.quit();
   }
   @BeforeClass
   public void launchUrl() {

        DriverManager.driver.manage().window().maximize();
        String baseUrl=config.getProperty("base_Url");
        DriverManager.driver.get(baseUrl);

   }


}
