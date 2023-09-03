package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class WindowPage {

    public static By windowPageLink = By.xpath("//a[normalize-space()='Tabs']");
    public static By windowPageView = By.xpath("//p[normalize-space()='Window']");
    public static By homePageButton = By.id("home");
    public static By multipleTabButton = By.id("multi");
}
