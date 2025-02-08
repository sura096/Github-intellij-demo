import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsMouseOperationsExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() throws InterruptedException {

        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();

        Thread.sleep(3000);
    }
    @Test
    public void mouseOperatioTest1() throws InterruptedException {

        driver.get("https://www.leafground.com/drag.xhtml");
        System.out.println("1) <<<<<<<<<<<Move to an element operation>>>>>>>>>>>");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);


        System.out.println("2) <<<<<<<<<<<Drag And Drop  operation>>>>>>>>>>>");





        System.out.println("1) <<<<<<<<<<<Slider Operation>>>>>>>>>>>");


    }


}
