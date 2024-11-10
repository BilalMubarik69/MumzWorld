package General;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Config.configProperties.platformName;
import static General.baseTest.webdriver;

public class webDriverWaits {
    public static WebDriverWait wait;
    public static WebDriverWait waits;


    public static void elementToBeClick( WebElement element )
    {
        if (platformName.contains("Android") | platformName.contains("iOS")) {
          wait= new WebDriverWait(webDriverFactory.getDriver(),20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            sleep(2000);
        }
        else if (platformName.contains("Chrome DeskTop")){
            waits=new WebDriverWait(webdriver,20);
            waits.until(ExpectedConditions.elementToBeClickable(element));
            sleep(2000);
        }
        }

    public static void invisibilityOf( WebElement element )
    {
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            wait= new WebDriverWait(webDriverFactory.getDriver(),20);
            wait.until(ExpectedConditions.invisibilityOf(element));
            sleep(2000);
        }
        else if (platformName.contains("Chrome DeskTop")){
            waits=new WebDriverWait(webdriver,20);
            waits.until(ExpectedConditions.invisibilityOf(element));
            sleep(2000);
        }    }

    public static void visibilityOf(WebElement element){
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            wait= new WebDriverWait(webDriverFactory.getDriver(),30);
            wait.until(ExpectedConditions.visibilityOf(element));
            sleep(2000);
        }
        else if (platformName.contains("Chrome DeskTop")){
            waits=new WebDriverWait(webdriver,20);
            waits.until(ExpectedConditions.visibilityOf(element));
            sleep(2000);
        }
    }
    public static void waitUntilElementIsClickable( WebElement element)
    {
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            wait= new WebDriverWait(webDriverFactory.getDriver(),20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            sleep(2000);
        }
        else if (platformName.contains("Chrome DeskTop")){
            waits=new WebDriverWait(webdriver,20);
            waits.until(ExpectedConditions.elementToBeClickable(element));
            sleep(2000);
        }    }
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public static void elementToBeClickNative( By element )
    {
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            wait= new WebDriverWait(webDriverFactory.getDriver(),20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            sleep(2000);
        }

    }
}
