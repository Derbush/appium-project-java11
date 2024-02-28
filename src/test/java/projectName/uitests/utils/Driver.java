package projectName.uitests.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static URL url;

    private Driver() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        String platform = ConfigurationReader.getProperty("platform");
        if (Objects.isNull(driver)) {
            switch (platform) {
                case "android":
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities);
                    break;

                case "android-remote":
                    DesiredCapabilities caps = new DesiredCapabilities();

                    // Set your access credentials
                    caps.setCapability("browserstack.user", "testuser_1PhU8f");
                    caps.setCapability("browserstack.key", "qxU7LUK78o8BK1ki799f");

                    // Set URL of the application under test
                    caps.setCapability("app", "bs://e0ce6dfd61f8f7d9fd9c4fb11c746b65fd1d79f1");

                    // Specify device and os_version for testing
                    caps.setCapability("device", "OnePlus 8");
                    caps.setCapability("os_version", "10.0");
                    caps.setCapability("realMobile", "true");

                    // Set other BrowserStack capabilities
                    caps.setCapability("project", "My test appium automation");
                    caps.setCapability("build", "Java Android");
                    caps.setCapability("name", "Regression");

                    // Initialise the remote Webdriver using BrowserStack remote URL
                    // and desired capabilities defined above
                    try {
                        driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "android-sauceLabApp":
                    DesiredCapabilities desiredCapabilities2 = new DesiredCapabilities();
                    desiredCapabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    desiredCapabilities2.setCapability(MobileCapabilityType.APP, "/Users/oscar/IdeaProjects/B28_AppiumAutomation/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    desiredCapabilities2.setCapability("appPackage", "com.swaglabsmobileapp");
                    desiredCapabilities2.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities2);
                    break;
                case "remote-android-swaglab":
                    // we get following capabilities setup from saucelab configurator, we change some lines according to our test need, and we need to add app location
                    String personalHubInfo = "oauth-XXXXXX-2ca62:4XXXXXXXc247364-XXXXXXXa2ea";
                    MutableCapabilities capsAndroid = new MutableCapabilities();
                    capsAndroid.setCapability("platformName", "Android");
                    capsAndroid.setCapability("appium:deviceName", "Samsung.*");
                    capsAndroid.setCapability("appium:deviceOrientation", "portrait");
                    capsAndroid.setCapability("appium:automationName", "UiAutomator2");
                    capsAndroid.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    capsAndroid.setCapability("appPackage", "com.swaglabsmobileapp");
                    capsAndroid.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("name", "swaglab test");
                    capsAndroid.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://" + personalHubInfo + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsAndroid); // polymorphism
                    break;
                case "remote-iphone-swaglab":
                    String personalHubInfoIOS = "oauth-XXXXXXXX-2ca62:4c247364-XXXX-4b73-b8df-2a2d945XXXXXba2ea";
                    MutableCapabilities capsIphone = new MutableCapabilities();
                    capsIphone.setCapability("platformName", "iOS");
                    capsIphone.setCapability("appium:deviceName", "iPhone Simulator");
                    capsIphone.setCapability("appium:platformVersion", "16.2");
                    capsIphone.setCapability("appium:deviceOrientation", "portrait");
                    capsIphone.setCapability("appium:automationName", "XCUITest");
                    capsIphone.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                    MutableCapabilities sauceOptionsIOS = new MutableCapabilities();
                    sauceOptionsIOS.setCapability("name", "swaglab test iphone");
                    capsIphone.setCapability("sauce:options", sauceOptionsIOS);
                    try {
                        url = new URL("https://" + personalHubInfoIOS + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new IOSDriver(url, capsIphone);
                    break;
                case "remote-android-swaglab-systemProp":
                    MutableCapabilities capsAndroidSYS = new MutableCapabilities();
                    capsAndroidSYS.setCapability("platformName", "Android");
                    capsAndroidSYS.setCapability("appium:deviceName", "Samsung.*");
                    capsAndroidSYS.setCapability("appium:deviceOrientation", "portrait");
                    capsAndroidSYS.setCapability("appium:automationName", "UiAutomator2");
                    capsAndroidSYS.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    capsAndroidSYS.setCapability("appPackage", "com.swaglabsmobileapp");
                    capsAndroidSYS.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptionsSYS = new MutableCapabilities();
                    sauceOptionsSYS.setCapability("name", "swaglab test");
                    sauceOptionsSYS.setCapability("username", System.getenv("SAUCE_USERNAME")); // need to set up env variables
                    sauceOptionsSYS.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    capsAndroidSYS.setCapability("sauce:options", sauceOptionsSYS);

                    try {
                        url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");   // need to provide either US or EU central hub
                        /*
                    private String SAUCE_EU_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";
                    private String SAUCE_US_URL = "https://ondemand.us-west-1.saucelabs.com/wd/hub";
                         */
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsAndroidSYS);
                    break;
                case "android-sauceLabApp-Zhenia":
                    DesiredCapabilities desiredCapabilities3 = new DesiredCapabilities();
                    desiredCapabilities3.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities3.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities3.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities3.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    desiredCapabilities3.setCapability(MobileCapabilityType.APP, "/Users/evgeniyaderbush/IdeaProjects/appium-project-java11/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    desiredCapabilities3.setCapability("appPackage", "com.swaglabsmobileapp");
                    desiredCapabilities3.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver(url, desiredCapabilities3); // polymorphism
                    break;
                case "remote-android-swaglab-Zhenia":
                  //  String personalHubInfo3 = "oauth-derbush.evgeniya-94703:02e9767e-0a50-4ae6-adf6-76bb754690fd";
                    // we get this capabilities from Sauce Lab configurator & we changed some lines according to our test needs
                    MutableCapabilities caps3 = new MutableCapabilities();
                    caps3.setCapability("platformName", "Android");
                    //caps3.setCapability("browserName", "Chrome"); no need
                    caps3.setCapability("appium:deviceName", "Samsung.*");
                    caps3.setCapability("appium:automationName", "UiAutomator2");
                   // we added
                   // caps3.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                    caps3.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    caps3.setCapability("appPackage", "com.swaglabsmobileapp");
                    caps3.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
                    // was provided:
                    MutableCapabilities sauceOptions3 = new MutableCapabilities();
                    sauceOptions3.setCapability("username", "oauth-derbush.evgeniya-94703");
                    sauceOptions3.setCapability("accessKey", "02e9767e-0a50-4ae6-adf6-76bb754690fd");
                    sauceOptions3.setCapability("build", "<your build id>");
                    sauceOptions3.setCapability("name", "Zhenia swaglab test");
                    caps3.setCapability("sauce:options", sauceOptions3);


                    try {
                    //    url = new URL("https://"+personalHubInfo3+"ondemand.us-west-1.saucelabs.com:443/wd/hub");
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps3);
                    break;
                case "remote-iphone-swaglab-Zhenia":
                    // we get this capabilities from Sauce Lab configurator & we changed some lines according to our test needs
                    MutableCapabilities caps4 = new MutableCapabilities();
                    caps4.setCapability("platformName", "iOS");
                   // caps.setCapability("browserName", "Safari");
                    caps4.setCapability("appium:deviceName", "iPhone.*");
                    caps4.setCapability("appium:automationName", "XCUITest");
                    caps4.setCapability(MobileCapabilityType.APP, "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                    MutableCapabilities sauceOptions4 = new MutableCapabilities();
                    sauceOptions4.setCapability("username", "oauth-derbush.evgeniya-94703");
                    sauceOptions4.setCapability("accessKey", "02e9767e-0a50-4ae6-adf6-76bb754690fd");
                    sauceOptions4.setCapability("build", "<your build id>");
                    sauceOptions4.setCapability("name", "MySecond Test");
                    caps4.setCapability("sauce:options", sauceOptions4);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new IOSDriver(url, caps4);
                    break;

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.closeApp();
            driver.quit();
            driver = null;
        }
    }
}