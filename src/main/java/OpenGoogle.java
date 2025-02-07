import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class OpenGoogle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/");
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);

       // driver.quit();
    }
}
