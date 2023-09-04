package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class DragDropPage {

    public static By dragDropPageLink = By.xpath("//a[normalize-space()='AUI - 2']");
    public static By dragDropPageView = By.xpath("//p[normalize-space()='Drop']");
    public static By draggableDiv = By.id("draggable");
    public static By droppableDiv = By.id("droppable");
    public static By droppableText = By.id("//div[@id='droppable']//p");
}
