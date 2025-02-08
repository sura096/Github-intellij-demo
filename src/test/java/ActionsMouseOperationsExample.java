import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37")))

       .moveToElement(driver.findElement(By.id("menuform:j_idt38")))

      .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();



        System.out.println("2) <<<<<<<<<<<Drag And Drop  operation>>>>>>>>>>>");

       WebElement from = driver.findElement(By.id("form:drag"));
       WebElement to = driver.findElement(By.id("form:drop"));

       //action.clickAndHold(from).moveToElement(to).release().perform(); //1st way
        action.dragAndDrop(from, to).perform(); //2nd way







        System.out.println("1) <<<<<<<<<<<Slider Operation>>>>>>>>>>>");

        WebElement sliderPoint1 = driver.findElement(By.xpath("//*[@id=\"form:j_idt125\"]/span[1]"));
        System.out.println("Location sliderPoint1 before moving:" + sliderPoint1.getLocation());
   action.dragAndDropBy(sliderPoint1, 50, 0).perform();
        System.out.println("Location sliderPoint1 after moving:" + sliderPoint1.getLocation());


    }


}
