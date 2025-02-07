import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_Checkbox_Example {

    WebDriver driver;

    @BeforeMethod

    public void radio_checkbox_beforeTest() {

        ChromeOptions chromeoption = new ChromeOptions();
        driver = new ChromeDriver(chromeoption); // Use instance variable instead of local variable
        driver.manage().window().maximize();


    }


    @Test
    public void radiotest() {
        //<<<<<<Radio>>>>>>>>
        //1) find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeRadioOption =  driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption =  driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption =  driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption =    driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadioOption) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is :" + chromeText);
        } else if (firefoxRadioOption) {
            String fireFoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is :" + fireFoxText);

        } else if (safariRadioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is : " + safariText);

        } else if (edgeRadioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is :" + edgeText);

        }
//2) select the group(only if not selected)
       WebElement myAgeGroup =  driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
           // myAgeGroup.click();
            driver.findElement(By.xpath("//*[@id=\"j_idt87:age\"]/div/div[1]/label")).click();


        }

    }

    @Test
    public void CheckBoxTest(){
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkBoxList){
            if (!(element.getText().equals("Others"))){
                element.click();


            }

        }

        for (int i=0; i<checkBoxList.size(); i++){
          boolean checkBoxStatus =   driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[3]/div/div//input["+ i+" ]")).isSelected();
            System.out.println("CheckBox" + i + "selected status is: " + checkBoxStatus);
        }
    }


}
