import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.DriverManager;

import java.sql.SQLOutput;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;
import util.ConfigFileReader;

import javax.swing.*;

public class Spreetest extends SuiteManager {
    private static ConfigFileReader config=new ConfigFileReader();

    //String emailInput=""

 /*private static ConfigFileReader config=new ConfigFileReader();
    String userName;
    String password;
    //public static WebDriver driver;
    @BeforeTest
    public void getUsernamePassword(){
        DriverManager.driver.manage().window().maximize();
        String userName=config.getProperty("username");
        String password=config.getProperty("password");


    }*/

    public BasePage basepage;
    public LoginPage loginpage;
    public HomePage homepage;
    public SearchResultPage searchpage;
    public productDetails productdetails;

   // Actions builder=new Actions(DriverManager.driver);
    //builder.dr

    @Test(dataProvider = "loginCredentials",dataProviderClass = loginCredentials.class )
    public void verifyLogin(String userName ,String password) {
        /*

         */

       // DriverManager driverManager = new DriverManager();
        basepage =new BasePage(DriverManager.driver);
        loginpage = basepage.clickLoginButton();
        homepage = loginpage.login(userName,password);
        String expectedata=loginpage.successMsg();
        Assert.assertTrue(expectedata.contains(config.getProperty("actualdata")));

        //List<String> products=searchpage.prodlist();



        /*DriverManager.driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        //DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(userName);
       // DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(password);
       // DriverManager.driver.findElement(By.xpath("//*[@name='commit']")).click();
        String actualdata = "Logged in successfully";
        String expectedata = DriverManager.driver.findElement(By.xpath("//main[@id='content']//*[@class='alert alert-success']")).getText();
        System.out.println("excepted text is" + expectedata);


        if (actualdata.equals(expectedata)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        /*DriverManager.driver.findElement(By.xpath("//a[@href='/t/bags']")).click();
        List<WebElement> prod = DriverManager.driver.findElements(By.className("card"));
        System.out.println("the size of the prod list " +prod.size());


       /* public void createAccount() {

            //WebDriver driver;
            DriverManager.driver.findElement(By.linkText("Create a new account")).click();
            //driver.findElement()
            DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("shalinip1017@gmail.com");
            DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("shalu1234");
            DriverManager.driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("shalu1234");
            DriverManager.driver.findElement(By.name("commit")).click();
        }*/
    }


@Test
    public void verifyProductList(){
        String searchitem=config.getProperty("searchItem");
    String username=config.getProperty("username");
    String password=config.getProperty("password");


    basepage =new BasePage(DriverManager.driver);
    loginpage = basepage.clickLoginButton();
    homepage = loginpage.login(username,password);
    String expectedata=loginpage.successMsg();
    Assert.assertTrue(expectedata.contains(config.getProperty("actualdata")));

    searchpage=homepage.enterSearchItem(searchitem);
    List<String> produlist=searchpage.oneProduct();

    for(int i=0;i<produlist.size();i++) {

       String title= produlist.get(i);
        Assert.assertTrue(title.toLowerCase().contains(config.getProperty("searchItem")));



    }




        }





    }

