package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends SuiteManager {
    private static ConfigFileReader config=new ConfigFileReader();


    public SearchResultPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(xpath = "//*[@id='products']//a")
    private List<WebElement> BagList;
    @FindBy(xpath = "//*[@title='Ruby on Rails Bag']")
    private WebElement RailsBag;


   /*public List<String> prodlist(WebElement List) {
       List<WebElement> prods = DriverManager.driver.findElements((By) List);
        List<String> currentOptions = new ArrayList<>();
        for (WebElement match : prods) {


            currentOptions.add(match.getText());
        }
        return currentOptions;
    }*/
    public List<String> oneProduct() {


        int prodSize = BagList.size();
        System.out.println(prodSize);


        List<String> produlist = new ArrayList<>();


            for (int i = 0; i < prodSize; i++) {



                produlist.add(BagList.get(i).getText());


            }
        return produlist;
    }

    public productDetails clickOnProduct(){

        RailsBag.click();
       return new productDetails();
    }

}
