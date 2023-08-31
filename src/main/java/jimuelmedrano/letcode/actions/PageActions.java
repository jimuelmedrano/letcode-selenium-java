package jimuelmedrano.letcode.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    public static void click(WebDriver driver, By element){
        getElement(driver,element).click();
    };

    public static void clickAndHold(WebDriver driver, By element){
        WebElement elm = getElement(driver,element);
        new Actions(driver)
                .clickAndHold(elm)
                .perform();
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

    public static Point getLocation(WebDriver driver, By element){
        return getElement(driver,element).getLocation();
    };

    public static String getColor(WebDriver driver, By element){
        //returns RGBA value
        return getElement(driver,element).getCssValue("color");
    };

    public static Dimension getSize(WebDriver driver, By element){
        //returns RGBA value
        return getElement(driver,element).getSize();
    };

    public static WebElement getElement(WebDriver driver, By element){
        WebElement webElement= driver.findElement(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> webElement.isDisplayed());
        return webElement;
    }
}
