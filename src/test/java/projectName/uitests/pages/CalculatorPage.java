package projectName.uitests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import projectName.uitests.utils.Driver;

public class CalculatorPage {

    public CalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy (accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy (accessibility = "equals")
    public MobileElement equals;

    @AndroidFindBy (id = "com.google.android.calculator:id/digit_2")
    public MobileElement two;

    @AndroidFindBy (id = "com.google.android.calculator:id/digit_6")
    public MobileElement six;

    @AndroidFindBy (id = "com.google.android.calculator:id/result_final")
    public MobileElement result;

    public void clickSingleDigit(int digit){
        String id ="com.google.android.calculator:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }

    public void multiply(){
        multiply.click();
    }


}

/*
@FindBy(css = "someBrowserCss") //this locator is used when here is browser (desktop or mobile)
@iOSFindBy(uiAutomator = ".elements()[0]") //this locator is used when here is iOS native content
@AndroidFindBy(className = "android.widget.TextView") //this locator is used when here is Android
//native content
public List<WebElement> androidOriOsTextViews;
 */
