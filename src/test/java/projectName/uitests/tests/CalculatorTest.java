package projectName.uitests.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    @Test
    public void calculatorAddTest() throws MalformedURLException {
        // DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
      //  caps.setCapability("deviceName",  "Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");


        //        capabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        //        URL url = new URL("http://localhost:4723/wd/hub")   no /wd/hub for Appium 2;

        // set URL for appium server

        URL url = new URL("http://localhost:4723");
        // http://localhost:4723 => it mean Appium is rurring in our local server and port is 4723
       // You can provide the following URLs in your client code to connect to this server:
        // http://127.0.0.1:4723

        //launch Appium Driver = it's an interface and has several implementations
        // AppiumDriver controls Android
        // IOSDriver controls ios
        // (url, caps) = we specify location/url of appium server
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, caps);

        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        Assertions.assertEquals("android", driver.getPlatformName());
        MobileElement clearElem = driver.findElement(MobileBy.AccessibilityId("clear"));
        System.out.println("Text of element " + clearElem.getText());
        Assertions.assertTrue(clearElem.isDisplayed());

        driver.closeApp();



        //close the app
    }


}

/*

Example:
AppiumDriver driver = null;
DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
desiredCapabilities.setCapability("deviceName", “Pixel 3");
        desiredCapabilities.setCapability("platform", "Android");
desiredCapabilities.setCapability("platformVersion", “10.0");
                                  desiredCapabilities.setCapability("app",

"https://cybertek-appium.s3.amazonaws.com/etsy.apk");

desiredCapabilities.setCapability("adbExecTimeout", "20000");
try {
driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
        e.printStackTrace();
}
*/
