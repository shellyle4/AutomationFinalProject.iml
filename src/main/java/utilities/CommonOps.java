package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base
{
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: getData
    Method description: This method get the data from the DataConfig.xml file
    Method parameters: String
    Method return: String */
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File ("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e) {
            System.out.println("Exception in reading XML file: "+e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initBrowser
    Method description: This method initiated the web browser according to the parameter entered
                        It also initiate all the elements that needed to working with web driver.
    Method parameters: String
    Method return: null */
    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
        {
            driver = initChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox"))
        {
            driver = initFirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("ie"))
        {
            driver = initIEDriver();
        }
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        actions = new Actions(driver);
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initChromeDriver
    Method description: This method initiate Chrome Driver
    Method parameters: null
    Method return: Chrome web driver */
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initFirefoxDriver
    Method description: This method initiate Firefox Driver
    Method parameters: null
    Method return: Firefox web driver */
    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initIEDriver
    Method description: This method initiate Internet Explorer Driver
    Method parameters: null
    Method return: Internet Explorer web driver */
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

     /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initMobile
    Method description: This method initiate Mobile driver
    Method parameters: null
    Method return: null
    */
    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium server, see details: "+e);
        }
        ManagePages.initmortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("Timout")));
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initAPI
    Method description: This method initiate connection to the server and send user name & password from DataConfig.xml file
                        using Preemptive Authentication (==REST Assured)
    Method parameters: null
    Method return: null */
    public static void initAPI()
    {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"),getData("Password"));
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: initElectron
    Method description: This method initiate Electron driver
    Method parameters: null
    Method return: null */

    public static void initElectron()
    {
       System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timout")));
        actions = new Actions(driver);
    }

     /*
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     Method name: initDesktop
     Method description: This method initiate Desktop driver
     Method parameters: null
     Method return: null
     */
    public static void initDesktop()
    {
        dc.setCapability("app",getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("DesktopServer")),dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium server. See details: "+e);
        }
        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timout")));
    }

        /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: startSession
    Method description: This method start the session.
    Method parameters: String
    Method return: null
    */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)
    {
        platform = PlatformName;

        if (platform.equalsIgnoreCase("web"))
        {
            initBrowser(getData("BrowserName"));
        }
        else if (platform.equalsIgnoreCase("mobile"))
        {
            initMobile();
        }
        else if (platform.equalsIgnoreCase("api"))
        {
            initAPI();
        }
        else if (platform.equalsIgnoreCase("electron"))
        {
            initElectron();
        }
        else if (platform.equalsIgnoreCase("desktop"))
        {
            initDesktop();
        }
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
    }
    @AfterClass
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: closeSession
    Method description: This method close session.
    Method parameters: null
    Method return: null
    */
    public void closeSession()
    {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api"))
        {
            if (!platform.equalsIgnoreCase("mobile"))
            {
                driver.quit();
            }
            else mobileDriver.quit();
        }
    }

    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: afterMethod
    Method description: This method clear the task list in electron test and reenter the url in web testing.
    Method parameters: null
    Method return: null
    */
    @AfterMethod
    public void afterMethod()
    {
        if (platform.equalsIgnoreCase("web"))
        {
            driver.get(getData("url"));
        }
        else if (platform.equalsIgnoreCase("electron"))
        {
            ElectronFlows.emptyList();
        }

    }

    @BeforeMethod
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: beforeMethod
    Method description: This method define that if it's api testing the test will not be recorded.
    Method parameters: Method
    Method return: null
    */
    public void beforeMethod(Method method)
    {
        if (!platform.equalsIgnoreCase("api"))
        {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
