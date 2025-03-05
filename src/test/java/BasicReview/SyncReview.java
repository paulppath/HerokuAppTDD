package BasicReview;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SyncReview
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/Users/paul/Documents/Selenium/libs/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Implicitly wait goes here
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://selenium-practice-app.herokuapp.com/?#/synchronization");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        String expectText = "Hello World!";
        driver.findElement(By.id("input-text")).sendKeys(expectText);
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Display']")).click();


        String actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='text-display' and text()='Hello World!']"))).getText();
        System.out.println(actual);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='text-display']")).getText(),expectText);

        driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.close();
    }
}
