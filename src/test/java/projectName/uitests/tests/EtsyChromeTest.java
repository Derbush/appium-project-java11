package projectName.uitests.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectName.uitests.utils.ConfigurationReader;

public class EtsyChromeTest extends WebTestBased{

    @Test
    public void etsySearch() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        Thread.sleep(5000);
        WebElement searchField = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='wt-display-inline']/span[1]"))));

        System.out.println(driver.findElement(By.xpath("//span[@class='wt-display-inline']/span[1]")).getText());

    }

    @Test
    public void test2() throws InterruptedException {
        String login = ConfigurationReader.getProperty("login");
        String password = ConfigurationReader.getProperty("password");
        driver.get("https://www.etsy.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//nav[@aria-label='Main']/ul/li")).click();
        driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys(login);
        driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
        Thread.sleep(5000);
    }



}
