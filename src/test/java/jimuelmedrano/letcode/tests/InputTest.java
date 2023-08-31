package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.InputPage;
import jimuelmedrano.letcode.utils.DriverSetup;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

public class InputTest extends Annotations {


    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.click(ds.driver, InputPage.inputPageLink);
    }

    @Test(priority = 1)
    public void inputFullName() throws InterruptedException{
        PageActions.inputText(ds.driver,InputPage.fullNameInput, FrameworkConstants.INPUT_FULL_NAME);
    }

    @Test(priority = 2)
    public void appendAndTab() throws InterruptedException{
        PageActions.inputText(ds.driver,InputPage.appendInput," at programming");
        PageActions.sendKeys(ds.driver,InputPage.appendInput, Keys.TAB);
    }

    @Test(priority = 3)
    public void getInputText() throws InterruptedException{
        String inputData = PageActions.getValue(ds.driver,InputPage.getTextInputBox);
        System.out.println("Input box text: " + inputData);
    }

    @Test(priority = 4)
    public void clearInputText() throws InterruptedException{
        PageActions.getElement(ds.driver,InputPage.clearTextInputBox).clear();
    }

    @Test(priority = 5)
    public void confirmDisabled() throws InterruptedException{
        if(PageActions.isEnabled(ds.driver,InputPage.disabledInput)){
            System.out.println("Element is Enabled");
        }else{
            System.out.println("Element is Disabled");
        };
    }

    @Test(priority = 6)
    public void confirmReadonly() throws InterruptedException{
        if(PageActions.isReadonly(ds.driver,InputPage.readonlyInput)){
            System.out.println("Element is Read-Only");
        }else{
            System.out.println("Element is Editable");
        };
    }


}
