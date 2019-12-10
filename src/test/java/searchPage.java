import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class searchPage extends SuiteManager {
   String searchItem;
    private static ConfigFileReader config=new ConfigFileReader();

    @BeforeTest
    public void getProd() {

        //DriverManager.driver.manage().window().maximize();
        searchItem = config.getProperty("searchItem");

    }
    @Test
    public void searchProduct(){
       // DriverManager.driver.get("https://spree-vapasi-prod.herokuapp.com/");
        DriverManager.driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("shalinip1017");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("shalu1234");
        DriverManager.driver.findElement(By.xpath("//*[@name='commit']")).click();



        DriverManager.driver.findElement(By.id("keywords")).sendKeys(searchItem);
        DriverManager.driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();

    }
}
