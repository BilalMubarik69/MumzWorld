package General;

import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import static Config.configProperties.platformName;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class baseTest {
    public static WebDriver driver;
    public static WebDriver webdriver;

    ExtentTest logger;
    public String dropdownValues;
    public int i;
    public Select select;
    public WebElement option;
    public String defaultItem;
    public String winHandleBefore;
    public WebElement dropdown;
    public String cssValue;
    public List<WebElement> options;
    @BeforeSuite()
    public void startReport() throws IOException {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Regression", "IF Web")
                        .put("Environment",envGlobals.appURL)

                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
        MainCall.startReport();
        webDriverFactory.startDriver();
    }
   @BeforeMethod()
    public void beforeTest(Method method) throws IOException {
        logger = MainCall.getExtentReport().startTest(method.getName(), "");
        logger.setStartedTime(getTime());
    }
    @AfterMethod()
    public void QuitDriver(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
        } else {
            logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
        }

        logger.setEndedTime(getTime());
        MainCall.getExtentReport().endTest(logger);
        MainCall.getExtentReport().flush();
        webDriverFactory.finishDriver();

    }

    private Date getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterTest()
    public void endReport() throws IOException {

    }

    public static void appURL(String url) {
        if (platformName.contains("Android") || platformName.contains("iOS") ) {
            webDriverFactory.getDriver().get(url);
        }
        else{
            webdriver.get(url);
        }
    }


    public static void Click(WebElement element) {
        if (platformName.contains("Android") || platformName.contains("iOS"))
        {
            JavascriptExecutor js = (JavascriptExecutor) webDriverFactory.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
        else {
            JavascriptExecutor js = (JavascriptExecutor) webdriver;
            js.executeScript("arguments[0].click();", element);
        }
    }


    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clearField(WebElement element) {
        element.clear();
    }

    public String getText(WebElement element) {
        String value = element.getText();
        return value;
    }
    public void switchFrame(WebElement element){
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            driver.switchTo().frame(element);
        }
        else{
            webdriver.switchTo().frame(element);
        }
    }
    public void switchBackFrame(){
        if (platformName.contains("Android") | platformName.contains("iOS")) {
            driver.switchTo().defaultContent();
        }
        else{
            webdriver.switchTo().defaultContent();
        }
    }
    public boolean isDisplayed(WebElement element) {
       boolean displayedElement=element.isDisplayed();
       return displayedElement;
    }

    public String getListText(List<WebElement> element, int index) {
        String value = element.get(index).getText();
        return value;
    }
    public void enterListInput(List<WebElement> element, int index,String input) {
        element.get(index).sendKeys(input);
    }
    public void ListClear(List<WebElement> element, int index) {
        element.get(index).clear();
    }

    public void selectByVisibleText(WebElement element, String value) {
        WebElement ele = element;
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(value);
    }

    public void draganddrop(WebElement drag, WebElement drop) {
        Actions act = new Actions(webDriverFactory.getDriver());
        WebElement dragele = drag;
        WebElement dropele = drop;
        act.dragAndDrop(dragele, dropele);
    }
    public void mouseHover(WebElement element) {
        Actions act = new Actions(webdriver);
        act.moveToElement(element).build().perform();
    }
    public void mouseHoverClick(WebElement element) {
        Actions act = new Actions(webdriver);
        act.moveToElement(element).click(element).build().perform();
    }


    public void getFirstSelectedOptionTextDropdown(WebElement element) {
        select = new Select(element);
        option = select.getFirstSelectedOption();
        defaultItem = option.getText();
        System.out.println(defaultItem);
    }

    public String getCssValue(WebElement element,String value){
        cssValue=element.getCssValue(value);
        System.out.println(cssValue);
        return  cssValue;
    }


    public  void clickDeviceBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void moveToElement(String path){
        WebElement element = webdriver.findElement(By.xpath(path));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(element);
        actions.click().perform();
    }
   public void nativeAppClick(AndroidElement element){

   }
}

