package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

public class productDetails {

    public productDetails(){
        PageFactory.initElements(DriverManager.driver,this);
    }


    @FindBy(css = ".lead.price.selling")
    private WebElement Price;


    public String getText(WebElement field) {
        String Price = field.getText();
        String price = Price;
        return price;
    }
    public void getPrice(){
        System.out.println(getText(Price));

    }



}
