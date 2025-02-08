import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {
    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() throws InterruptedException {

        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
        Thread.sleep(3000);
    }
    @Test
    public void frameTests(){

        //1. click me inside frame
driver.switchTo().frame(0);
WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
button1.click();

String afterClickButtonText = button1.getText();
        System.out.println("After click inside frame button text" + afterClickButtonText);
        //2. click me inside nested frame

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
    WebElement button3 =     driver.findElement(By.xpath("//*[@id=\"Click\"]"));
    button3.click();
        String afterClickNestedButtonText = button3.getText();
        System.out.println("After click inside nested frame button text" + afterClickButtonText);

        driver.switchTo().defaultContent();
     List<WebElement>  getframeTagCount=   driver.findElements(By.tagName("iframe"));
     int size = getframeTagCount.size();
        System.out.println("iframe Tag Count: " + size);


        //3. how many frame in the page


    }
}
