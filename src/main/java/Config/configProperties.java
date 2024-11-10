package Config;


public class configProperties {

    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String platformName = appConfig.getPlatformName();
    public static String platformVersion = appConfig.getPlatformVersion();
    public static String deviceName = appConfig.getDeviceName();
    public static String automationName = appConfig.getAutomationName();
    public static String browserName = appConfig.browserName();
    public static String Environment = appConfig.getEnvironment();

}
