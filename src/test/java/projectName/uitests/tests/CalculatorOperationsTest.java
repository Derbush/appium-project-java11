package projectName.uitests.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorOperationsTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        URL url = new URL("http://localhost:4723");

        driver = new AndroidDriver<>(url, caps);


    }

    @Test
    public void addTest(){
        /*
        4 + 5 = 9
         */
        MobileElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals")); // MobileBy. for accessabilityID

        four.click();
        plus.click();
        five.click();
        equals.click();

       // WaitMethods.waitForPresenceAndGetText(driver, 30, "No formula",result);
       // Integer.parseInt(result.getText()); to get int

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actResult = result.getText();
        System.out.println("actResult = " + actResult);

        int expResult = 9;

        assertEquals(expResult, Integer.parseInt(actResult));


    }

    @Test
    public void devideTest() {
        /*
        15/5 = 3
         */

        MobileElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement devide = driver.findElement(MobileBy.AccessibilityId("divide"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));

        one.click();
        five.click();
        devide.click();
        five.click();
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        assertEquals("3", result.getText());
    }

    @AfterEach
    public void cleanUp(){
        driver.closeApp();
    }
}
