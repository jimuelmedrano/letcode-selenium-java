package jimuelmedrano.letcode.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    public static void click(WebDriver driver, By element){
        waitUntil(driver,element).click();
    };

    public static void inputText(WebDriver driver, By element, String text){
        waitUntil(driver,element).sendKeys(text);
    };

    public static void sendKeys(WebDriver driver, By element, Keys keys){
        waitUntil(driver,element).sendKeys(keys);
    };

    public static String getText(WebDriver driver, By element){
        return waitUntil(driver,element).getText();
    };

    static WebElement waitUntil(WebDriver driver, By element){
        WebElement webElement= driver.findElement(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> webElement.isDisplayed());
        return webElement;
    }
}
