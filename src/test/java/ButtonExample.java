
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonExample {

    WebDriver driver;

    // Initialize WebDriver before each test
    @BeforeMethod
    public void openbuttonexample() {

        ChromeOptions chromeoption = new ChromeOptions();
        chromeoption.setBrowserVersion("128");

        driver = new ChromeDriver();  // Use instance variable instead of local variable
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);

       // driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@Test
    public void buttonTest(){
    // Click & Confirm Title
    driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]/span")).click();
    String expectedTitle = "Dashboard";
    String actualTitle = driver.getTitle();
    if (expectedTitle.equals(actualTitle)){
        System.out.println("Actual Title Same as expected");
    } else {
       System.out.println("Actual Title Not same as expected");


    }

    //find the position of the submit button
    driver.navigate().back();
    WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
    Point xyPoint = getPosition.getLocation();
    int x = xyPoint.getX();
    int y = xyPoint.getY();
    System.out.println("X position is : " + x + "Y position is :" + y );


//find the save button color
    WebElement buttoncolour = driver.findElement(By.id("j_idt88:j_idt96"));
    String color = buttoncolour.getCssValue(" background-color");
    System.out.println("button color is: " + color);


    //find the height & width of this month

    WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
    int hight = size.getSize().getHeight();
    int width = size.getSize().getWidth();
    System.out.println("Heigh:" + hight + "width :" + width);






}


}
