package projectName.uitests.utils;

public class Changes_ClientJava9_TestBase {

    /* Here you can find changes to desired capabilities in Java-client 9

    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //device settings
        desiredCapabilities.setCapability("appium:chromedriverExecutable", "/Users/evgeniyaderbush/IdeaProjects/appium-project-java11/chromedriver");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        // desiredCapabilities.setCapability("deviceName", "Pixel 3");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);

        // desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        URL url = new URL("http://localhost:4723");
        //  driver = new RemoteWebDriver(url, desiredCapabilities); // we use remote bc we need to connect to the server

        driver = new AndroidDriver(url, desiredCapabilities);

    }

    @AfterEach
    public void tearDown(){
        driver.quit();

    }

     */

}
