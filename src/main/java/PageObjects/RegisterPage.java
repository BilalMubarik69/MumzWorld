package PageObjects;

import General.baseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class RegisterPage extends baseTest{

  @FindBy(id = "sign_in_button")
  WebElement SignInButton;

  @FindBy(id="email")
  WebElement emailTextField;

  @FindBy(id="password")
  WebElement passwordTextField;

  @FindBy(xpath="//button[contains(@id,'sign_in')]")
  WebElement signInButtonFooter;
  public RegisterPage(WebDriver driver) {
            this.webdriver = driver;
            PageFactory.initElements(driver, this);
    }
  public void clickSignInButton(){
    Click(SignInButton);
  }


  public void enterEmail(String email){
        sendKeys(emailTextField,email);
  }
  public void enterPassword(String password){
    sendKeys(passwordTextField,password);
  }

  public void clickSignInButtonFooter(){
    Click(signInButtonFooter);
  }
  public void signIn(){
    clickSignInButton();
    enterEmail("bilalmub@gmail.com");
    enterPassword("Bilal.1234");
    clickSignInButtonFooter();
  }
}
