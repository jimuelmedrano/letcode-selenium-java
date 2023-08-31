package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class ButtonPage {

    public static By buttonPageLink = By.xpath("//a[normalize-space()='Click']");
    public static By goToHomeButton = By.id("home");
    public static By locationButton = By.id("position");
    public static By colorButton = By.id("color");
    public static By sizeButton = By.id("property");
    public static By disabledButton = By.id("isDisabled");
    public static By holdButton = By.xpath("//label[normalize-space()='Click and Hold Button']//following-sibling::div//button");
    public static By holdButtonText = By.xpath("//label[normalize-space()='Click and Hold Button']//following-sibling::div//button//h2");
}
