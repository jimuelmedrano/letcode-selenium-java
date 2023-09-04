package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class FramePage {

    public static By framePageLink = By.xpath("//a[normalize-space()='Inner HTML']");
    public static By framePageView = By.xpath("//p[normalize-space()='Frame']");
    public static By firstFrame = By.id("firstFr");
    public static By firstName = By.name("fname");
    public static By lastName = By.name("lname");
    public static By innerFrame = By.xpath("//iframe[@src='innerFrame']");
    public static By email = By.name("email");
}
