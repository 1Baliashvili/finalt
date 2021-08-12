import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;

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
        Wait wait = new WebDriverWait(driver,100);
        driver.findElement(By.className("dropdown")).click();
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
        driver.findElement(By.xpath(("//li[@class='dropdown']/a[text()='Desktops']"))).click();
        //driver.findElement(By.xpath(("//li[@class='dropdown']/div[@class='dropdown-menu']/a"))).click();
        driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();
        driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'MP3 Players')]")).click();
        WebElement ele = driver.findElement(By.xpath("//img[@alt='iPod Shuffle']"));

//Creating object of an Actions class
        Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

        driver.findElement(By.linkText("iPod Shuffle")).click();
        driver.findElement(By.xpath("//img[@alt='iPod Shuffle']")).click();
        while(true)
        {
            if(driver.findElement(By.xpath("//div[@class='mfp-counter']")).getText().equals("5 of 5"))
            {
                break;
            }
            else driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();

        }
        driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();
        driver.findElement(By.xpath("//a[text()='Write a review']")).click();
        //js executor fill info
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement h = driver.findElement(By.xpath("//h2[text()='Write a review']"));
        js.executeScript("arguments[0].scrollIntoView();",h);
        driver.findElement(By.id("input-review")).sendKeys("this product is awesome this product is awesome");
        driver.findElement(By.xpath("//div[@class='col-sm-12']/input[@value='5']")).click();
        driver.findElement(By.id("button-review")).click();
        //wait sheidzleba
        String startcarttotal = driver.findElement(By.id("cart-total")).getText();
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(1000);
        wait.until(new ExpectedCondition <Boolean>() {
            public Boolean apply(WebDriver driver)
            {
                return driver.findElement(By.id("cart-total")).getText() != startcarttotal;
            }
        });
        //aqac wait unda
        String carttotal = driver.findElement(By.id("cart-total")).getText();
        if(!startcarttotal.equals(carttotal))
        {
            System.out.println("you have just added new item succesfully");
        }
        else
        {
            System.out.println("there are not any new item");
        }
//        System.out.println(startcarttotal);
//        System.out.println(carttotal);

        driver.findElement(By.id("cart-total")).click();
        driver.findElement(By.xpath("//p[@class='text-right']/a[2]")).click();
        //filling info

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-10']/input[@id='input-payment-firstname']")));
        WebElement el1 = driver.findElement(By.id("input-payment-city"));
        js.executeScript("arguments[0].scrollIntoView();",el1);

        driver.findElement(By.xpath("//div[@class='col-sm-10']/input[@id='input-payment-firstname']")).sendKeys("Bachana");
        driver.findElement(By.id("input-payment-lastname")).sendKeys("Baliashvili");
          //filling company name with js
        WebElement company = driver.findElement(By.id("input-payment-company"));
        js.executeScript("arguments[0].value='TBCG';",company);
        driver.findElement(By.id("input-payment-address-1")).sendKeys("georgia Tbilisi 1");
        driver.findElement(By.id("input-payment-address-2")).sendKeys("Georgia Tbilisi 2");
        driver.findElement(By.id("input-payment-city")).sendKeys("Tbilisi");
        driver.findElement(By.id("input-payment-postcode")).sendKeys("123456");
        Select name = new Select(driver.findElement(By.cssSelector("select[id='input-payment-country']")));
        name.selectByVisibleText("Georgia");
        Select name1 = new Select (driver.findElement(By.cssSelector("select[id='input-payment-zone']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Tbilisi']")));
        name1.selectByVisibleText("Tbilisi");
        driver.findElement(By.xpath("//div[@class='pull-right']/input[@id='button-payment-address']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-right']/input[@id='button-shipping-address']")));
        driver.findElement(By.xpath("//div[@class='pull-right']/input[@id='button-shipping-address']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-shipping-method']")));
        driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();






    }

}