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
        String inputText = PageActions.getText(driver,InputPage.appendInput);
        PageActions.inputText(driver,InputPage.appendInput," at programming");
        PageActions.sendKeys(driver,InputPage.appendInput, Keys.TAB);
    }

}
