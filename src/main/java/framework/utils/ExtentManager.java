package framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" +
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("API Automation Report");
            spark.config().setReportName("ReqRes API Tests");
            spark.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
