package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.AlertPage;
import jimuelmedrano.letcode.pages.ButtonPage;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AlertTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.click(ds.driver, AlertPage.alertPageLink);
    }

    @Test(priority = 1)
    public void acceptSimpleAlert() throws InterruptedException{
        PageActions.click(ds.driver, AlertPage.simpleAlert);
        ds.driver.switchTo().alert().accept();
    }

    @Test(priority = 2)
    public void dismissAndPrintAlert() throws InterruptedException{
        PageActions.click(ds.driver, AlertPage.dismissAlert);
        Alert alert = ds.driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.dismiss();
    }

    @Test(priority = 3)
    public void inputAlertText() throws InterruptedException{
        PageActions.click(ds.driver, AlertPage.promptAlert);
        Alert alert = ds.driver.switchTo().alert();
        alert.sendKeys(FrameworkConstants.FIRST_NAME);
        alert.accept();
        String expectedText = "Your name is: " + FrameworkConstants.FIRST_NAME;
        String resultText = PageActions.getText(ds.driver, AlertPage.inputAlert);
        Assert.assertEquals(resultText,expectedText);
    }

    @Test(priority = 4)
    public void modernAlert() throws InterruptedException{
        PageActions.click(ds.driver, AlertPage.modernAlert);
        PageActions.click(ds.driver, AlertPage.closeModernAlert);
    }

}
