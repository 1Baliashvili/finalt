import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class finalj {
    WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else{
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void uploading() throws InterruptedException{
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
        driver.findElement(By.id("input-email")).sendKeys("bachana"+a+"@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys(a);
        driver.findElement(By.id("input-password")).sendKeys(a);
        driver.findElement(By.id("input-confirm")).sendKeys(a);
        driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='agree' and @value='1']")).click();
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath()));
        Thread.sleep(2000);

        driver.close();
        driver.quit();






    }

}