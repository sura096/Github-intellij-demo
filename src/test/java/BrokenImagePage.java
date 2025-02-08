import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagePage {

    WebDriver driver;

    @BeforeMethod
    public void openImagePage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions); // Use instance variable instead of local variable
        driver.manage().window().maximize();

        Thread.sleep(3000);

    }
    @Test
            public void findBrokenImageTest(){
        driver.get("http://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));


        //"naturalWidth" = 0

        int i = 0;
        for (WebElement image:images){

            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image" + i +  "is Broken");
            }else {
                System.out.println("Image"  + i + "is not Broken");
            }
            i++;




        }




    }

}
