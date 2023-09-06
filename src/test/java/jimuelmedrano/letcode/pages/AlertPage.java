package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class AlertPage {

    public static By alertPageLink = By.xpath("//a[normalize-space()='Dialog']");
    public static By simpleAlert = By.id("accept");
    public static By dismissAlert = By.id("confirm");
    public static By promptAlert = By.id("prompt");
    public static By inputAlert = By.id("myName");
    public static By modernAlert = By.id("modern");
    public static By closeModernAlert = By.xpath("//button[@aria-label='close']");
}
