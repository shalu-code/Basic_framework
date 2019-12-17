package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class HomePage extends SuiteManager {
    private static ConfigFileReader config=new ConfigFileReader();

    public HomePage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(css = "#keywords")
    private WebElement searchBox;
    @FindBy(xpath = "//input[@type='submit' and @value='Search']")
    private WebElement searchButton;


    public void enterValue(WebElement field, String value){

        field.click();
        field.clear();
        field.sendKeys(value);
    }



    public SearchResultPage enterSearchItem(String searchitem){
        enterValue(searchBox,searchitem);

        searchButton.click();
       return new SearchResultPage();
    }

}
