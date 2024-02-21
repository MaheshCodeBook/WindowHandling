package WindowHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;


public class ArticleHubPageTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaarticlehub.ccbp.tech/");

        String parentWindowHandle = driver.getWindowHandle();

        WebElement articleEle = driver.findElement(By.className("article-container"));
        articleEle.click();

        Set<String> windowHandlesSet = driver.getWindowHandles();

        for (String windowHandlw : windowHandlesSet){
            if (!(windowHandlw.equals(parentWindowHandle))){
                driver.switchTo().window(windowHandlw);

                WebElement heading = driver.findElement(By.className("article-details-title"));
                System.out.println(heading.getText());

                WebElement contentElement = driver.findElement(By.className("article-content"));
                System.out.println(contentElement.getText());
                driver.close();
            }
        }
        driver.quit();
    }
}
