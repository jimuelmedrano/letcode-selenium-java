package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.AlertPage;
import jimuelmedrano.letcode.pages.FramePage;
import jimuelmedrano.letcode.pages.WindowPage;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, WindowPage.windowPageView);
        PageActions.click(ds.driver, WindowPage.windowPageLink);
    }

    @Test(priority = 1)
    public void newTabPrintHandle() throws InterruptedException{
        PageActions.click(ds.driver, WindowPage.homePageButton);
        System.out.println("Parent Tab Title: " + ds.driver.getTitle());
        //After opening new tab, the active tab here is still the old tab, switch window will set the new tab as the active tab
        PageActions.switchWindow(ds.driver);
        System.out.println("New Tab Title: " + ds.driver.getTitle());
    }

    @Test(priority = 2)
    public void printAllTabTitle() throws InterruptedException{
        PageActions.click(ds.driver, WindowPage.multipleTabButton);
        System.out.println("All tab titles:");
        //Iterate through all window handles
        for (String windowHandle : ds.driver.getWindowHandles()) {
            //Switch to the window with current handle and print the title
            String title = ds.driver.switchTo().window(windowHandle).getTitle();
            System.out.println(title);
        }
    }


}
