package TestCases;

import General.baseTest;
import General.envGlobals;
import PageObjects.RegisterPage;
import PageObjects.addToCardPage;
import PageObjects.homePage;
import org.testng.annotations.Test;

public class checkoutRegisterTests extends baseTest {
    homePage homePage;
    addToCardPage addToCardPage;
    RegisterPage RegisterPage;
    @Test(priority=0)
    public void verifyHomePage() {
        try {

                homePage=new homePage(webdriver);
                homePage.verifyHomePage();
        }
        finally {
            baseTest.appURL(envGlobals.appURL);
        }
    }
    @Test(priority = 1)
    public void verifySearchProduct() throws InterruptedException {
          try {
              homePage = new homePage(webdriver);
              homePage.verifyProductSearchFlow();
          }
          finally {
              baseTest.appURL(envGlobals.appURL);

          }
    }
    @Test(priority = 2)
    public void addToCartWithoutSignIn(){
        try{
            homePage = new homePage(webdriver);
            addToCardPage=new addToCardPage(webdriver);
            homePage.verifyProductSearchFlow();
            addToCardPage.addItemToCartWithOutSignIn();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            baseTest.appURL(envGlobals.appURL);

        }
    }
    @Test(priority = 3)
    public void signIn(){
        RegisterPage= new RegisterPage(webdriver);
        RegisterPage.signIn();
    }

}
