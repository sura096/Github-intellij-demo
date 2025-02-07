import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    // Initialize WebDriver before each test
    @BeforeMethod
    public void dropDowntestpage() {
        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();
    }

    @Test
    public void leafgroundpageDropdownTest() throws InterruptedException {
        // 1.1 Selecting values in a basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");

        // 1.2 Get the number of dropdown options
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements in dropdown: " + size);

        for (WebElement element : listofOptions) {
            System.out.println(element.getText());
        }

        // 1.3 Using send keys to select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        // 1.4 Selecting values in a bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element : listdropdown2values) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

    // Separate test for Google search
   
}





















// 3  handle hidden auto suggetions dropdown and search using DOM debugger trick

