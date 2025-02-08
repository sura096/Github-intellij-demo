import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v128.filesystem.FileSystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions); // Use instance variable instead of local variable
        driver.manage().window().maximize();

        Thread.sleep(3000);


    }

    @Test
    public void downloadFileTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton =  driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);
        File file = new File("C:\\Users\\MiyuruHasaranjana\\Downloads");
        File[] totalFiles =  file.listFiles();
        for (File findFile:totalFiles){

            if (findFile.getName().equals("TestLeaf Logo.png"));
            System.out.println("File Is Download");
            break;
        }

    }

    @Test
    public void uploadFileTest() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");
//       WebElement uploadButton =  driver.findElement(By.id("j_idt88:j_idt89"));
//       uploadButton.click();
//
//       //Windows Control Begin Here
//
//        String data = "C:\\Users\\MiyuruHasaranjana\\Downloads\\TestLeaf Logo.png";
//        StringSelection selection = new StringSelection(data);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//
//
//        Thread.sleep(3000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//
       Thread.sleep(3000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);



        // 2nd way using sendkeys (Applicable only element type is file)

        String data = "C:\\Users\\MiyuruHasaranjana\\Downloads\\TestLeaf Logo.png";
       WebElement uploadUsingSendKeys =  driver.findElement(By.id("j_idt88:j_idt89"));
       uploadUsingSendKeys.sendKeys(data);
    }

}