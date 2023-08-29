package jimuelmedrano.letcode.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    public static void click(WebDriver driver, By element){
        getElement(driver,element).click();
    };

    public static void inputText(WebDriver driver, By element, String text){
        getElement(driver,element).sendKeys(text);
    };

    public static void sendKeys(WebDriver driver, By element, Keys keys){
        getElement(driver,element).sendKeys(keys);
    };

    public static String getText(WebDriver driver, By element){
        return getElement(driver,element).getText();
    };

    public static String getValue(WebDriver driver, By element){
        return getElement(driver,element).getAttribute("value");
    };

    public static boolean isEnabled(WebDriver driver, By element){
        return PageActions.getElement(driver,element).isEnabled();
    };

    public static boolean isReadonly(WebDriver driver, By element){
        String readonly = PageActions.getElement(driver,element).getAttribute("readonly");
        if(readonly != null && readonly.equals("true")){
            return true;
        }else{return false;}
    };

    public static WebElement getElement(WebDriver driver, By element){
        WebElement webElement= driver.findElement(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> webElement.isDisplayed());
        return webElement;
    }
}
