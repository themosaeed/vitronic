import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airarabia.com/en");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(HomePage.departureCityFeild()).isDisplayed());
    }

    @AfterMethod
    public void flush(){
        driver.quit();
    }
}
