package WindowHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class CountryPageTest {

    public static void switchWindowByUrl(String url, WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(url)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qacountrypage.ccbp.tech/");

        WebElement findPopulationButton = driver.findElement(By.id("findPopulationBtn"));
        findPopulationButton.click();

        WebElement answerQuestionBtn = driver.findElement(By.id("answerQuestionBtn"));
        answerQuestionBtn.click();

        switchWindowByUrl("https://qasearchpage.ccbp.tech/", driver);
        WebElement searchInputField = driver.findElement(By.id("searchInput"));
        searchInputField.sendKeys("Italy");

        WebElement populationText = driver.findElement(By.className("country-population"));
        System.out.println(populationText.getText());

        switchWindowByUrl("https://qaquestion.ccbp.tech/", driver);
        WebElement questionText = driver.findElement(By.className("question"));
        System.out.println(questionText.getText());

        WebElement delhiRadioButton = driver.findElement(By.id("cityDelhi"));
        delhiRadioButton.click();

        WebElement submitButton = driver.findElement(By.id("submitBtn"));
        submitButton.click();

        WebElement resultText = driver.findElement(By.id("resultMsg"));
        System.out.println(resultText.getText());

        driver.quit();
    }
}