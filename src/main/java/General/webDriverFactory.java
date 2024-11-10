package General;

import Config.configProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Config.configProperties.platformName;

public class webDriverFactory extends baseTest{
    public static AppiumDriver driver;
    public static AppiumDriver<MobileElement> getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static void startDriver() throws IOException {
        switch (platformName) {
            case "Android":
                driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilitiesGenerator.getCapabilities());
                baseTest.appURL(envGlobals.appURL);
                driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
                break;

            case "iOS":
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilitiesGenerator.getCapabilities());
                baseTest.appURL(envGlobals.appURL);
                driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                break;

            case "Chrome DeskTop":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-extensions");
                options.addArguments("enable-strict-powerful-feature-restrictions");
                options.addArguments("disable-geolocation");
                options.addArguments();
                options.addArguments("--start-maximized");
                Map < String, Object > prefs = new HashMap < String, Object > ();
                Map < String, Object > profile = new HashMap < String, Object > ();
                Map< String, Object > contentSettings = new HashMap< String, Object >();
                contentSettings.put("geolocation", 1);
                profile.put("managed_default_content_settings", contentSettings);
                prefs.put("profile", profile);
                options.setExperimentalOption("prefs", prefs);
                webdriver = new ChromeDriver(options);
                baseTest.appURL(envGlobals.appURL);
                webdriver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                break;

            case "Firefox DeskTop":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffopt = new FirefoxOptions()
                        //.addPreference("dom.webnotifications.enabled", false)
                        .addPreference("geo.enabled", 1);
                webdriver=new FirefoxDriver(ffopt);
                baseTest.appURL(envGlobals.appURL);
                webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                break;
        }
    }
    public static String getDevice()
    {
        webDriverWaits.sleep(250);
        return configProperties.platformName;
    }

    public static void finishDriver() throws IOException {
        if (driver != null)
        {
            webDriverWaits.sleep(1000);
            driver.quit();
            driver = null;
        }
    }
}
