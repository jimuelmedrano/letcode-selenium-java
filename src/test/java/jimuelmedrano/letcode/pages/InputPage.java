package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class InputPage{

    public static By inputPageLink = By.xpath("//a[normalize-space()='Edit']");
    public static By fullNameInput = By.id("fullName");
    public static By appendInput = By.id("join");
    public static By getTextInputBox = By.id("getMe");
    public static By clearTextInputBox = By.id("clearMe");
    public static By disabledInput = By.id("noEdit");
    public static By readonlyInput = By.id("noEdit");

}
