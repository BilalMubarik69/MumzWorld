package General;




import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    static ExtentTest test;

    public static ExtentReports startReport(){
        extent = new ExtentReports(System.getProperty("user.dir") +"/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", String.valueOf(Environment));;
        return extent;
    }

    public static ExtentReports getExtentReport(){
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }
}
