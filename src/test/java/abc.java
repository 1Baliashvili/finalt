import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class abc {

    @Test
    public void uploading() throws InterruptedException{
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a")).click();

        //fil info
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime localTime = LocalTime.now();
        String a = dtf.format(localTime);
        driver.findElement(By.id("input-firstname")).sendKeys("Bachana");
        driver.findElement(By.id("input-lastname")).sendKeys("Baliashvili");
        driver.findElement(By.id("input-email")).sendKeys("bachana@gmail.com");

//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath()));
        Thread.sleep(2000);

        driver.close();
        driver.quit();






    }

}