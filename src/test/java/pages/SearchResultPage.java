package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends SuiteManager {
    private static ConfigFileReader config=new ConfigFileReader();


    public SearchResultPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(xpath = "//*[@id='products']//a")
    private List<WebElement> BagList;


   /*public List<String> prodlist(WebElement List) {
       List<WebElement> prods = DriverManager.driver.findElements((By) List);
        List<String> currentOptions = new ArrayList<>();
        for (WebElement match : prods) {


            currentOptions.add(match.getText());
        }
        return currentOptions;
    }*/
    public void oneProduct(){


        int prodSize = BagList.size();
        System.out.println(prodSize);
        if(prodSize>0) {
            for (int i = 0; i <prodSize; i++) {

                String title = BagList.get(i).getText();
                System.out.println(title);

                Assert.assertTrue(title.toLowerCase().contains(config.getProperty("searchItem")));

            }

        }
        else {
            System.out.println("products are not matching");

        }

    }

//public void items(){

       //int size= prodlist(BagList).size();

//}

}
