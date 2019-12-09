import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Spreetest {


public static WebDriver driver;

    public void login()

    {

        driver.manage().timeouts().implicitlyWait(
                50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("shalinip1017@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("shalu1234");
        driver.findElement(By.xpath("//*[@name='commit']")).click();
        String actualdata="Logged in successfully";
        String expectedata= driver.findElement(By.xpath("//main[@id='content']//*[@class='alert alert-success']")).getText();
        System.out.println("excepted text is" +expectedata);


        if(actualdata.equals(expectedata)) {
            System.out.println("pass");
        }
        else {
            System.out.println("fail");
        }
     driver.close();

    }



    public void createAccount()
        {
            //WebDriver driver;
        driver.findElement(By.linkText("Create a new account")).click();
        //driver.findElement()
        driver.findElement(By.id("spree_user_email")).sendKeys("shalinip1017@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("shalu1234");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("shalu1234");
        driver.findElement(By.name("commit")).click();



    }

    public void checkout()
    {

        driver.findElement(By.xpath("//a[@href='/t/bags']")).click();
        List<WebElement> prod = driver.findElements(By.xpath("//div[@id='products']"));
        System.out.println("the size of the prod list " +prod.size());
        //System.out.println("first item" +prod.get(0));
        //System.out.println("second item" +prod.get(1));
    }
    @Test
    public void startmethod()
    {



        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
         driver = new ChromeDriver();


        driver.get("https://spree-vapasi-prod.herokuapp.com/");


        Spreetest test=new Spreetest();
        test.login();
        //test.checkout();







    }
}
