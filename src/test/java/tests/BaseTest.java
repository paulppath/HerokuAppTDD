package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.ConfigReader;
import util.ExtentManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest
{

    String path = ConfigReader.readProperty("config.properties", "path");
//    String path = "/Users/paulppath/Desktop/Selenium/libs/drivers/chromedriver";

    //1.1  Firstly we declare a WebDriver name driver.
    //      But to improve this, we can make our driver a singleton object by declare
    //          private static WebDriver driver;
    //      then create a getDriver static method that return our driver
    //      and also static method for all the method that need to use the private static WebDriver driver

    WebDriver driver;
    // 1.2 We also declare a static ExtendManager name reportManager
    protected static ExtentManager reportManager;

    // 2. We create report for the suite
    @BeforeSuite(alwaysRun = true)
    public void startReporter()
    {
        reportManager = new ExtentManager();
        reportManager.createReport();
    }

    // 3. Before each test we
    // 3.1 initialize driver
    // 3.2 driver.get
    // 3.3 create report for each test
    @BeforeMethod(alwaysRun = true)
    public void baseSetUp(Method method)
    {
        WebDriverManager.chromedriver().setup(); // The WebDriverManager dependency that work as
        System.setProperty("webdriver.chrome.driver", path);

        // 3.1 We initialize driver in initializeDriver method depend on what browser we are using
        //     and initialize the driver that we declared earlier
        initializeDriver(ConfigReader.readProperty("config.properties","browser"));
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 3.2 driver.get
        driver.get(ConfigReader.readProperty("config.properties","url"));
        // 3.3 create report for each test
        reportManager.createTestReport(driver, method);
    }

    // 4. AfterMethod/After each test we close each test report and driver.quit
    @AfterMethod(alwaysRun = true)
    public void baseTearDown(ITestResult result)
    {
        reportManager.closeTestReport(result);
        driver.quit();
    }

    // At the end of the test we close the whole report
    @AfterSuite(alwaysRun = true)
    public void closeReporter()
    {
        reportManager.closeReporter();
    }
    public void initializeDriver(String browser)
    {
        switch(browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }
    }
    // test git branch paul
    
}
