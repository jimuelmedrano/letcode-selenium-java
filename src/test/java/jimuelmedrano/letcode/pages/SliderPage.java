package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class SliderPage {

    public static By sliderPageLink = By.xpath("//a[normalize-space()='AUI - 5']");
    public static By sliderPageView = By.xpath("//p[normalize-space()='Slider']");
    public static By sliderRange = By.id("generate");
    public static By generateButton = By.xpath("//button[normalize-space()='Get Countries']");
    public static By resultText = By.xpath("//p[@class='has-text-primary-light']");
}
