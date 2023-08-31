package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.InputPage;
import jimuelmedrano.letcode.utils.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class InputTest extends Hooks {

    @Test(priority = 1)
    public void inputFullName() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);
        PageActions.inputText(driver,InputPage.fullNameInput, FrameworkConstants.INPUT_FULL_NAME);
    }

    @Test(priority = 2)
    public void appendAndTab() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);
        PageActions.inputText(driver,InputPage.appendInput," at programming");
        PageActions.sendKeys(driver,InputPage.appendInput, Keys.TAB);
    }

    @Test(priority = 3)
    public void getInputText() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);
        String inputData = PageActions.getValue(driver,InputPage.getTextInputBox);
        System.out.println("Input box text: " + inputData);
    }

    @Test(priority = 4)
    public void clearInputText() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);
        PageActions.getElement(driver,InputPage.clearTextInputBox).clear();
    }

    @Test(priority = 5)
    public void confirmDisabled() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);

        if(PageActions.isEnabled(driver,InputPage.disabledInput)){
            System.out.println("Element is Enabled");
        }else{
            System.out.println("Element is Disabled");
        };
    }

    @Test(priority = 6)
    public void confirmReadonly() throws InterruptedException{
        PageActions.click(driver,InputPage.inputButton);
        if(PageActions.isReadonly(driver,InputPage.readonlyInput)){
            System.out.println("Element is Read-Only");
        }else{
            System.out.println("Element is Editable");
        };
    }

}
