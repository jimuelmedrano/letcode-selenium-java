package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class DropdownPage {

    public static By dropdownPageLink = By.xpath("//a[normalize-space()='Drop-Down']");
    public static By selectFruits = By.id("fruits");
    public static By selectFruitsResult = By.xpath("//select[@id='fruits']//parent::div//following-sibling::div//p");
    public static By selectHeroes = By.id("superheros");
    public static By selectLast = By.id("lang");
    public static By selectCountry = By.id("country");
}
