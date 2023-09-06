package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.DragDropPage;
import jimuelmedrano.letcode.pages.ElementsPage;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DragDropTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, DragDropPage.dragDropPageView);
        PageActions.click(ds.driver, DragDropPage.dragDropPageLink);
    }

    @Test(priority = 1)
    public void dragAndDropDiv() throws InterruptedException{
        PageActions.dragDropElement(ds.driver, DragDropPage.draggableDiv, DragDropPage.droppableDiv);
    }

}
