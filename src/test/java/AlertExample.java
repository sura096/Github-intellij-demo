import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod

    public void alertTestPage() {

        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }


    @Test
    public void alertTest() throws InterruptedException {

        //1. Alert simple dialog
WebElement alertBox =  driver.findElement(By.id("j_idt88:j_idt91"));
alertBox.click();

Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
alert.accept();

// Alert (Confirm Dialog)
       WebElement confirmBox =  driver.findElement(By.id("j_idt88:j_idt93"));
       confirmBox.click();
       Alert alert1 = driver.switchTo().alert();
       Thread.sleep(3000);
       alert1.dismiss();

       WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
       promptBox.click();
       Alert alert2 = driver.switchTo().alert();
       Thread.sleep(3000);
      String alertText =  alert2.getText();
        System.out.println("Alert Text Is:" + alertText);
        alert2.sendKeys("My Name is miyuru");
        alert2.accept();


    }
}

