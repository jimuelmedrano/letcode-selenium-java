package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.AlertPage;
import jimuelmedrano.letcode.pages.FramePage;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, FramePage.framePageView);
        PageActions.click(ds.driver, FramePage.framePageLink);
    }

    @Test(priority = 1)
    public void parentToFrame() throws InterruptedException{
        PageActions.switchFrame(ds.driver,FramePage.firstFrame);
        PageActions.inputText(ds.driver, FramePage.firstName, FrameworkConstants.FIRST_NAME);
        PageActions.inputText(ds.driver, FramePage.lastName, FrameworkConstants.LAST_NAME);
        PageActions.switchFrame(ds.driver,FramePage.innerFrame);
        PageActions.inputText(ds.driver, FramePage.email, FrameworkConstants.EMAIL);
    }

    @Test(priority = 2)
    public void frameToParent() throws InterruptedException{
        PageActions.switchFrame(ds.driver,FramePage.firstFrame);
        PageActions.switchFrame(ds.driver,FramePage.innerFrame);
        PageActions.inputText(ds.driver, FramePage.email, FrameworkConstants.EMAIL);
        ds.driver.switchTo().parentFrame();
        PageActions.inputText(ds.driver, FramePage.firstName, FrameworkConstants.FIRST_NAME);
        PageActions.inputText(ds.driver, FramePage.lastName, FrameworkConstants.LAST_NAME);
    }


}
