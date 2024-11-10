package PageObjects;

import General.baseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class homePage extends baseTest{
  
  @FindBy(id = "mumz_logo_img")
  WebElement verifyHome;

  @FindBy(id = "search_textbox")
  WebElement searchProductFIeld;

  @FindBy(xpath= "//*[contains(@title,'Gear')]")
  WebElement searchProductSelection;

  @FindBy(xpath = "//*[contains(@class,'ProductCard')]")
  WebElement productCardDisplay;

  public homePage(WebDriver driver) {
            this.webdriver = driver;
            PageFactory.initElements(driver, this);
    }
  public void clickHomePageLogo(){
    Click(verifyHome);
  }


    public void verifyHomePage(){
         Boolean verifyHomePage=isDisplayed(verifyHome);
         Assert.assertTrue(verifyHomePage,"Logo is not displayed Successfully");
    }

    public void enterSearchProduct(String productName){
      sendKeys(searchProductFIeld,productName);
    }

    public void clickStrollerSearchOption(){
      Click(searchProductSelection);
    }
    public void searchProduct() throws InterruptedException {
      enterSearchProduct("Stroller");
      Thread.sleep(5000);
      clickStrollerSearchOption();
    }
    public void verifyProductCardDisplay(){
      Boolean productCard= isDisplayed(productCardDisplay);
      Assert.assertTrue(productCard,"Search result List not Searched Successfully");
    }
    public void verifyProductSearchFlow() throws InterruptedException {
      searchProduct();
      verifyProductCardDisplay();
    }



}
