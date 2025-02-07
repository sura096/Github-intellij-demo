import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class LinkExample {
    WebDriver driver;

    // Initialize WebDriver before each test
    @Before
    public void openTestLink() {

        ChromeOptions chromeoption = new ChromeOptions();
        chromeoption.setBrowserVersion("128");

        driver = new ChromeDriver();  // Use instance variable instead of local variable
        driver.get("https://www.leafground.com/link.xhtml;jsessionid=node019x7f31650yt5u6otz7y5mcfe8164253.node0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void linkTest() {
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));

        homelink.click();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // find my destination
  WebElement wheretogo =  driver.findElement(By.partialLinkText("Find the URL without c"));
  String path = wheretogo.getAttribute("href");
  System.out.println("This Link coun to:" + path);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


  // am i broken link
      WebElement brokenlink =   driver.findElement(By.linkText("Broken?"));
      brokenlink.click();
      String title = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


      if(title.contains("404")){
          System.out.println("Broken");
      }
else {
          System.out.println("not broken");
      }
driver.navigate().back();
// duplicate link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


// count page link

        List<WebElement> countfullpagelinks =  driver.findElements(By.tagName("a"));
        int countfulllink =   countfullpagelinks.size();
        System.out.println("Count of link :" + countfulllink);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // count payout links

        WebElement layoutlink = driver.findElement(By.className("layout-main-content"));
        List<WebElement> linkcount = layoutlink.findElements(By.tagName("a"));
        System.out.println("count:" + linkcount);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    }

