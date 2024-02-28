package projectName.uitests.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import projectName.uitests.utils.ConfigurationReader;
import projectName.uitests.utils.Driver;

import javax.swing.*;

public class SauceLabAppTest {

    @Test
    public void TestLogin() throws InterruptedException {


        AppiumDriver<MobileElement> driver = Driver.getDriver();
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        Thread.sleep(5000);
        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys(ConfigurationReader.getProperty("loginSwagLab"));
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys(ConfigurationReader.getProperty("passwordSwagLab"));
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();

      //cast our driver to AndroidDriver
       // ((AndroidDriver)driver).findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");

        ((IOSDriver)driver).findElementsByXPath("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");

        Thread.sleep(5000);





        Driver.closeDriver();


    }
}
