import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import suite.SuiteManager;
import sun.jvm.hotspot.utilities.Assert;
import util.DriverManager;

import java.sql.SQLOutput;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Spreetest extends SuiteManager {


    //public static WebDriver driver;
    @Test
    public void verifyLogin() {

       // DriverManager driverManager = new DriverManager();
        DriverManager.driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("shalinip1017@gmail.com");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("shalu1234");
        DriverManager.driver.findElement(By.xpath("//*[@name='commit']")).click();
        String actualdata = "Logged in successfully";
        String expectedata = DriverManager.driver.findElement(By.xpath("//main[@id='content']//*[@class='alert alert-success']")).getText();
        System.out.println("excepted text is" + expectedata);


        if (actualdata.equals(expectedata)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        DriverManager.driver.findElement(By.xpath("//a[@href='/t/bags']")).click();
        List<WebElement> prod = DriverManager.driver.findElements(By.className("card"));
        System.out.println("the size of the prod list " +prod.size());

        //driver.close();

    }




}
