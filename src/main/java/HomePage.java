import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver =driver;
    }

    public static By departureCityFeild() {return By.xpath("(//input[@name=\"flying-from\"])[2]");}

    By destinationCityFeild = By.xpath("//input[@name=\"flying-to\"]");
    By returnRadio = By.xpath("//label[@for=\"journey_type_rt\"]");
    By depDate = By.xpath("//input[@name=\"deptdate\"]");
    By returnDateFeild = By.xpath("//input[@name=\"rtndate\"]");
    By passengersAdult = By.xpath("//select[@name=\"pax_adult\"]");
    By passengersInfants = By.xpath("//select[@name=\"pax_infant\"]");
    By submitButton = By.xpath("//input[@class=\"btn-filled-red search-button\"]");
    By CookiesAcceptButton = By.id("onetrust-accept-btn-handler");
    By datepickerMonth = By.xpath("//span[@class=\"ui-datepicker-month\"]");
    By datepickerYear = By.xpath("//span[@class=\"ui-datepicker-year\"]");
    By datepickerNext = By.xpath("//a[@data-handler=\"next\"]");

    public static By datepickerDay(String day){
        return By.xpath("(//span[text()=\""+day+"\"])[2]");
    }

    By DeptdateDay = By.xpath("//a[text()=\"4\"]");
    By returndateDay = By.xpath("//a[text()=\"5\"]");

    public FlightDetailsPage selectFlight(String departureCity , String DestinationCity,String depTargetMonth, String depTargetYear, String depTargetDay,String returnTargetMonth, String returnTargetYear, String returnTargetDay ,String numberOfAdults, String numberOfInfants){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(CookiesAcceptButton).click();
        driver.findElement(departureCityFeild()).sendKeys(departureCity);
        driver.findElement(destinationCityFeild).sendKeys(DestinationCity);
        driver.findElement(returnRadio).click();
        driver.findElement(depDate).click();
        wait.until(d -> driver.findElement(DeptdateDay).isDisplayed());
        driver.findElement(DeptdateDay).click();
        driver.findElement(returnDateFeild).click();
        wait.until(d -> driver.findElement(returndateDay).isDisplayed());
        driver.findElement(returndateDay).click();
        driver.findElement(passengersAdult).sendKeys(numberOfAdults);
        driver.findElement(passengersInfants).sendKeys(numberOfInfants);
        driver.findElement(submitButton).click();
        return new FlightDetailsPage(driver);
    }



}
