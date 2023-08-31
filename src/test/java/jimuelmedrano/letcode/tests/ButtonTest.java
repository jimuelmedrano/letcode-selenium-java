package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.ButtonPage;
import jimuelmedrano.letcode.utils.DriverSetup;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.Color;
import org.testng.annotations.*;

public class ButtonTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.click(ds.driver, ButtonPage.buttonPageLink);
    }

    @Test(priority = 1)
    public void clickHomeAndBack() throws InterruptedException{
        PageActions.click(ds.driver, ButtonPage.goToHomeButton);
        ds.driver.navigate().back();
    }

    @Test(priority = 2)
    public void getButtonCoordinate() throws InterruptedException{
        Point location = PageActions.getLocation(ds.driver, ButtonPage.locationButton);
        System.out.println("Button Coordinate: " + location);
    }

    @Test(priority = 3)
    public void getButtonColor() throws InterruptedException{
        //get rgba color
        String rgba = PageActions.getColor(ds.driver, ButtonPage.colorButton);
        //convert rgba to hex
        String hex = Color.fromString(rgba).asHex();
        System.out.println("Button RGBA Color: " + rgba);
        System.out.println("Button Hex Color: " + hex);
    }

    @Test(priority = 4)
    public void getButtonSize() throws InterruptedException{
        Dimension size = PageActions.getSize(ds.driver,ButtonPage.sizeButton);
        System.out.println("Button Size: " + size);
    }

    @Test(priority = 5)
    public void confirmDisabledButton() throws InterruptedException{
        if(PageActions.isEnabled(ds.driver,ButtonPage.disabledButton)){
            System.out.println("Element is Enabled");
        }else{
            System.out.println("Element is Disabled");
        };
    }

    @Test(priority = 6)
    public void holdButton() throws InterruptedException{
        String buttonTextBefore = PageActions.getText(ds.driver,ButtonPage.holdButtonText);
        System.out.println("Before Hold: " + buttonTextBefore);
        PageActions.clickAndHold(ds.driver, ButtonPage.holdButton);
        Thread.sleep(1000);
        String buttonTextAfter= PageActions.getText(ds.driver,ButtonPage.holdButtonText);
        System.out.println("After Hold: " + buttonTextAfter);
    }

}
