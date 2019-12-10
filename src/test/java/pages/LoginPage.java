package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class LoginPage extends SuiteManager {
    public LoginPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
   @FindBy(id= "spree_user_email")
    private WebElement usernameField;

    @FindBy(id = "spree_user_password")
    private  WebElement passwordField;

    @FindBy(name="commit")
    private WebElement submit;

    public void enterValue(WebElement field, String value){

        field.click();
        field.clear();
        field.sendKeys(value);
    }
  public HomePage login(String username,String password){

        enterValue(usernameField, username);
        enterValue(passwordField, password);
        submit.click();
        return new HomePage();
  }

}
