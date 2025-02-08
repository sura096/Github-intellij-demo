import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderExample {
    WebDriver driver;

    @BeforeMethod
    public void openCalenderTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions); // Use instance variable instead of local variable
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);



    }

    @Test
    public void calenderTest() throws InterruptedException {
       //method 1
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
       WebElement datePicker =  driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
       //datePicker.sendKeys("06/01/1995");

       // method2
        while (true){

            String actualMonth  = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();;
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(2024) && actualMonth.equals("May")){

                break;
            } else{
                driver.findElement(By.xpath("//div[@id='ui-datepicker-div']")).click();
            }


        }



    }
}
