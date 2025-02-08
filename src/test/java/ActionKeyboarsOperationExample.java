import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;

public class ActionKeyboarsOperationExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() throws InterruptedException {

        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();

        Thread.sleep(3000);

    }

    @Test
public void KeyBoardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.lk/");
        WebElement googleSearchTextBox = driver.findElement(By.id("APjFqb"));
//        googleSearchTextBox.sendKeys("welcome");
//
//
     Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(3000);
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentences").perform();
//        Thread.sleep(5000);
//
//               actions .keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .build().perform();

          // To write in capital in Textbox
        actions.keyDown(googleSearchTextBox, Keys.SHIFT).
                sendKeys("learn with hashir")
                .perform();

    }
@Test
    public void
    KeyBoardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);
       List<WebElement>  selectable = driver.findElements(By.xpath("//*[@id=\"pickList\"]/div[2]/ul/li"));

       int size = selectable.size();
    System.out.println("List of Size:" + size);

    Actions action2 = new Actions(driver);

    action2.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).click(selectable.get(2)).click(selectable.get(3)).perform();
}
}
