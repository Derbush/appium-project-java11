package projectName.uitests.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

    public static String waitForPresenceAndGetText(AppiumDriver driver, int timeLimitInSeconds, String accessibilityId, MobileElement mobileElement) {

        String text = "";

        int maxReTry = 10;
        for (int i = 0; i < maxReTry; i++) {
            try {
                mobileElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("\" +accessibilityId+\""));
                WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
                wait.until(ExpectedConditions.visibilityOf(mobileElement));
                text = mobileElement.getText();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Exception. Retrying...");
            }

        }
        return text;
    }
}

/*
public static MobileElement mobileElement;

public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId){

try{
	mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+targetResourceId+"\")");
	WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
	wait.until(ExpectedConditions.visibilityOf(mobileElement));
	isElementPresent = mobileElement.isDisplayed();
	return isElementPresent;
}catch(Exception e){
	isElementPresent = false;
	System.out.println(e.getMessage());
	return isElementPresent;
} }
 */
