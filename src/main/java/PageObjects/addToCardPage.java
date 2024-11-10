package PageObjects;

import General.baseTest;
import General.webDriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class addToCardPage extends baseTest{

  @FindBy(className = "//h2[contains(@class,'productName')]")
  WebElement verifyProduct;

  @FindBy(xpath = "//*[contains(@id,'increase_button')]")
  WebElement incrementCountforQTY;

  @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
  WebElement addToCartButton;

  @FindBy(xpath = "//h3[contains(@class,'font-extraBold mt')]")
  WebElement itemAddedSuccess;

  @FindBy(xpath = "//a[contains(text(),'View Cart')]")
  WebElement viewCartButton;

  @FindBy(xpath = "//label[contains(text(),'Infant Activity')]")
  WebElement infantCategory;

  @FindBy(xpath = "//a[contains(text(),'Star Babies')]")
  WebElement productCardDisplay;

  @FindBy(xpath = "//button[contains(text(),'Proceed to Checkout')]")
  WebElement proceedToCheckoutButton;

  @FindBy(xpath = "//h1[contains(@class,'text')]")
  WebElement SignInPage;


  public addToCardPage(WebDriver driver) {
            this.webdriver = driver;
            PageFactory.initElements(driver, this);
    }
  public void productNameOnDetailsPage() throws InterruptedException {
    webDriverWaits.visibilityOf(verifyProduct);
    Thread.sleep(1000);
    Boolean verifyProductName=isDisplayed(verifyProduct);
    Assert.assertTrue(verifyProductName,"Product Details not open for selected Product");
  }
  public void AddFiveQtyOfProductIntoCart(){
        for (i=0;i<=4;i++){
          Click(incrementCountforQTY);
        }
  }
  public void clickAddToCartButton(){
       Click(addToCartButton);
  }

  public void verifyItemAddedToCart(String text) throws InterruptedException {
    webDriverWaits.visibilityOf(itemAddedSuccess);
    Thread.sleep(1000);
    String itemText=getText(itemAddedSuccess);
    Assert.assertEquals(itemText,text);
  }

  public void viewCartButton(){
    Click(viewCartButton);
  }
  public void addItemToCartWithOutSignIn() throws InterruptedException {
    infantCategorySelection();
    clickProductCard();
    AddFiveQtyOfProductIntoCart();
    clickAddToCartButton();
    verifyCartAddedSuccess();
    viewCartButton();
    proceedCheckoutButton();
    signInPage("Sign In");

  }
  public void verifyCartAddedSuccess() throws InterruptedException {
    verifyItemAddedToCart("Item added to cart");
  }
  public void infantCategorySelection() throws InterruptedException {
    webDriverWaits.waitUntilElementIsClickable(infantCategory);
    Thread.sleep(1000);
    Click(infantCategory);
  }
  public void clickProductCard() throws InterruptedException {
    webDriverWaits.waitUntilElementIsClickable(productCardDisplay);
    Thread.sleep(1000);
    Click(productCardDisplay);
  }
  public void proceedCheckoutButton() throws InterruptedException {
    webDriverWaits.waitUntilElementIsClickable(proceedToCheckoutButton);
    Thread.sleep(1000);
    Click(proceedToCheckoutButton);
  }
  public void signInPage(String text) throws InterruptedException {
    webDriverWaits.visibilityOf(SignInPage);
    Thread.sleep(3000);
    String signInPage=getText(SignInPage);
    Assert.assertEquals(signInPage,text);
  }
}
