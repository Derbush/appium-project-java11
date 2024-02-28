package projectName.uitests.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import projectName.uitests.utils.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyAppTest {

    @Test
    public void etsyTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // device settings
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

        // settings related to app
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");

        // getting error: [ADB] Getting focused package and activity
        // so we need to add package and main activity
        caps.setCapability("appPackage", "com.etsy.android");
        caps.setCapability("appActivity", "com.etsy.android.ui.homescreen.HomescreenTabsActivity");

        URL url = new URL("http://localhost:4723");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");



        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, caps);

        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        Thread.sleep(3000);
       // driver.findElement(By.id("com.etsy.android:id/menu_bottom_nav_you")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.etsy.android:id/clg_text_input")).sendKeys(ConfigurationReader.getProperty("login" + Keys.ENTER));
        // driver.hidekeyboard() method
        Thread.sleep(3000);
        driver.findElement(By.id("com.etsy.android:id/you_menu_sign_in_button")).click();



        driver.closeApp();
    }
}
