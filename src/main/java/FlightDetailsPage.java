import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import java.time.Duration;

public class FlightDetailsPage {

    WebDriver driver;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    By firstOptionButton = By.xpath("(//button[@ng-class=\"{'selected' : flight.isFlightSelected }\"])[1]");
    By firstReturnOptionButton = By.xpath("(//button[@ng-class=\"{'selected' : flight.isFlightSelected }\"])[5]");
    By selectFirstclass = By.xpath("(//span[text()=\"Select\"])[2]");
    By selectReturnFirstClass = By.xpath("(//span[text()=\"Select\"])[3]");
    By totalPrice = By.xpath("//span[@class=\"currency-value fare-value price font-weight-bold xssm-curval amount-right ng-isolate-scope\"]");

    public void selectFaresAndPrintFinalValue(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(firstOptionButton).isDisplayed());
        driver.findElement(firstOptionButton).click();
        wait.until(d -> driver.findElement(selectFirstclass).isDisplayed());
        driver.findElement(selectFirstclass).click();
        wait.until(d -> driver.findElement(firstReturnOptionButton).isDisplayed());
        driver.findElement(firstReturnOptionButton).click();
        wait.until(d -> driver.findElement(selectReturnFirstClass).isDisplayed());
        driver.findElement(selectReturnFirstClass).click();
        wait.until(d -> driver.findElement(totalPrice).isDisplayed());
        String totalPriceValue = driver.findElement(totalPrice).getText();
        System.out.println(totalPriceValue);

    }
}
