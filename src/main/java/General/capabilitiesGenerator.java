package General;

import Config.configProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static Config.configProperties.platformName;

public class capabilitiesGenerator {

    public static DesiredCapabilities getCapabilities(){
       WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", configProperties.platformName);
        capabilities.setCapability("platformVersion",configProperties.platformVersion);
        capabilities.setCapability("deviceName",configProperties.deviceName);
        capabilities.setCapability("automationName", configProperties.automationName);
        capabilities.setCapability("browserName", configProperties.browserName);
        switch (platformName){
            case "Android":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", false);
                capabilities.merge(chromeOptions);
        }

        return capabilities;
    }

}
