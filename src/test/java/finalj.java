import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
        driver.get("http://the-internet.herokuapp.com/upload ");
        driver.manage().window().maximize();
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
        uploadInput.sendKeys("C:\\Users\\Administrator\\Downloads\\selenium.png");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(2000);

        try {
            uploadInput.sendKeys("C:\\Users\\Administrator\\Downloads\\selenium.png");
        }
        catch (StaleElementReferenceException e)
        {
            System.out.println(e.getMessage());
        }






    }
    @Test
    public void hoverAndDelete() throws InterruptedException{
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement toDoItem = driver.findElement(By.xpath("//li[text()=' Practice magic']"));
        action.moveToElement(toDoItem);
        action.perform();
        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('i.fa.fa-trash').last().click()");
        Thread.sleep(1000);
    }
    @Test
    public void scrollAndValidate() throws InterruptedException{
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();

        WebElement entries = driver.findElement(By.xpath("//div[@id='zone2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",entries);
        String text = js.executeScript("return arguments[0].innerText;",entries).toString();
        System.out.println(text);
        Thread.sleep(1000);
    }
}