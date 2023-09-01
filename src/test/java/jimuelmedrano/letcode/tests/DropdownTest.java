package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.ButtonPage;
import jimuelmedrano.letcode.pages.DropdownPage;
import jimuelmedrano.letcode.utils.Annotations;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.click(ds.driver, DropdownPage.dropdownPageLink);
    }

    @Test(priority = 1)
    public void selectOneOption() throws InterruptedException{
        PageActions.selectByVisibleText(ds.driver, DropdownPage.selectFruits,"Apple");
        String resultText = PageActions.getText(ds.driver, DropdownPage.selectFruitsResult);
        String expectedText = "You have selected Apple";
        Assert.assertEquals(resultText,expectedText);
    }

    @Test(priority = 2)
    public void selectMultipleOptions() throws InterruptedException{
        PageActions.selectByVisibleText(ds.driver, DropdownPage.selectHeroes,"Doctor Strange");
        PageActions.selectByVisibleText(ds.driver, DropdownPage.selectHeroes,"Ghost Rider");
        PageActions.selectByVisibleText(ds.driver, DropdownPage.selectHeroes,"Iron Man");
        List<WebElement> selectedList = PageActions.getSelectedOptions(ds.driver,DropdownPage.selectHeroes);

        System.out.println("Selected Options:");
        selectedList.forEach(
                (elm) -> {
                    System.out.println(elm.getText());
                }
        );
    }

    @Test(priority = 3)
    public void selectAndPrintAllOption() throws InterruptedException{
        List<WebElement> options = PageActions.getAllSelectOptions(ds.driver,DropdownPage.selectLast);
        PageActions.selectByIndex(ds.driver, DropdownPage.selectLast,options.size()-1);
        System.out.println("All Options:");
        options.forEach(
                (elm) -> {
                    System.out.println(elm.getText());
                }
        );
    }

    @Test(priority = 4)
    public void selectOptionValue() throws InterruptedException{
        PageActions.selectByVisibleText(ds.driver, DropdownPage.selectCountry,"India");
        List<WebElement> selectedList = PageActions.getSelectedOptions(ds.driver,DropdownPage.selectCountry);
        System.out.println("Selected Country:");
        selectedList.forEach(
                (elm) -> {
                    System.out.println(elm.getText());
                }
        );
    }

}
