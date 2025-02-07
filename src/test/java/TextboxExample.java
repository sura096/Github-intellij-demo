import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TextboxExample {
    WebDriver driver;

    // Initialize WebDriver before each test
    @Before
    public void openTestLink() {

        ChromeOptions chromeoption = new ChromeOptions();
        chromeoption.setBrowserVersion("128");


        driver = new ChromeDriver(chromeoption);  // Use instance variable instead of local variable
        driver.get("https://www.leafground.com/input.xhtml");
        driver.manage().window().maximize();

    }
    @Test
            public void textboxTest()
    {
// 1. Type Your Name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Miyuru");
// 2. Append country this city
 WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
 country.clear();
 country.sendKeys("Chennai");
        //3.  Verify is textbox disable
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println(" Is Enable ?" + enabled);
        // 4. clear the type text
       WebElement cleartext =  driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
       cleartext.clear();

        // 5.retrieve the type text
        WebElement retrive = driver.findElement(By.id("j_idt88:j_idt97"));
       String value =  retrive.getAttribute("value");
        System.out.println(value);
// Type Email & tab
      WebElement emailtext =   driver.findElement(By.id("j_idt88:j_idt99"));
      emailtext.sendKeys("miyuru096@gmail.com" + Keys.TAB + "control confiem to next element");




    }
}
