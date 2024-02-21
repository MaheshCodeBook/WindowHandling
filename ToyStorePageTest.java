package WindowHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class ToyStorePageTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qatoystore.ccbp.tech/");

        String parentWindowHandle = driver.getWindowHandle();

        WebElement productEle = driver.findElement(By.className("product"));
        productEle.click();

        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles ){
            if (!(windowHandle.equals(parentWindowHandle))) {
                driver.switchTo().window(windowHandle);

                WebElement nameElement = driver.findElement(By.className("product-name"));
                System.out.println(nameElement.getText());

                WebElement priceElement = driver.findElement(By.className("price-details"));
                System.out.println(priceElement.getText());

                WebElement descriptionElement = driver.findElement(By.className("product-description"));
                System.out.println(descriptionElement.getText());

                driver.close();

            }
        }
        driver.quit();
    }

}
