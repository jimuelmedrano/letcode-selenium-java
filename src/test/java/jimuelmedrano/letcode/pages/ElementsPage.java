package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class ElementsPage {

    public static By elementsPageLink = By.xpath("//a[normalize-space()='Find Elements']");
    public static By elementsPageView = By.xpath("//p[normalize-space()='Frame']");
    public static By usernameInput = By.name("username");
    public static By searchButton = By.id("search");
    public static By profilePicture = By.xpath("//div[@class='media-left']//img");
    public static By profileName = By.xpath("//div[@class='media-content']//p[1]");
    public static By otherInfoElements = By.xpath("//div[@class='tags has-addons']//span");
    public static By repoList = By.xpath("//ol//li//a");
}
