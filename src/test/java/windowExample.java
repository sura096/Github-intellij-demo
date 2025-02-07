import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowExample {


    WebDriver driver;

    @BeforeMethod
    public void windowTestPage() throws InterruptedException {
        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);

    }

    @Test
    public void windowTests() throws InterruptedException {

        //1. click and confirm new window opens
        String oldWindow = driver.getWindowHandle();
        System.out.println("parent Window:" + oldWindow);


        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));

        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println(" Handle Size: " + handles.size());

        // first method using foreach loop

        //  for (String newWindow :handles){
        //  System.out.println("newWindow");
        //  driver.switchTo().window(newWindow);
        {


        }
        // System.out.println("PAge Title is: " + driver.getTitle());


//driver.close();

        // driver.switchTo().window(oldWindow);


        // second method using list

        List<String> list = new ArrayList<>(handles); // converting set to list

        if (list.size() > 1) {

            driver.switchTo().window(list.get(1));
            System.out.println("psge title is: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("open button visibility :" + openbuttonVisibility);


        //2) find the number of open tabs

        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindow.click();
        Thread.sleep(3000);

       Set<String> multiWindows =  driver.getWindowHandles();
       int howmanyWindows = multiWindows.size();
        System.out.println(" Number Of Windows Open:" + howmanyWindows);

        //3. close all windows  except primary

       WebElement dontclosemeButton =  driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt93\"]/span[2]"));
       dontclosemeButton.click();
       Thread.sleep(3000);

       Set<String> newWindowsHandle = driver.getWindowHandles();
       for (String allwindows :newWindowsHandle){

           if (!allwindows.equals(oldWindow)){
               driver.switchTo().window(allwindows);
               driver.close();

           }
       }
driver.quit();


    }

}

