package jimuelmedrano.letcode.pages;

import org.openqa.selenium.By;

public class FormPage {

    public static By formPageLink = By.xpath("//a[normalize-space()='All in One']");
    public static By formPageView = By.xpath("//p[normalize-space()='Forms']");
    public static By firstNameInput = By.id("firstname");
    public static By lastNameInput = By.id("lasttname");
    public static By emailInput = By.id("email");
    public static By countryCodeSelect = By.xpath("//label[@id='countrycode']//parent::div//select");
    public static By phoneInput = By.id("Phno");
    public static By addressLine1Input = By.id("Addl1");
    public static By addressLine2Input = By.id("Addl2");
    public static By stateInput = By.id("state");
    public static By postalInput = By.id("postalcode");
    public static By countrySelect = By.xpath("//label[@id='country']//parent::div//select");
    public static By dateOfBirthInput = By.id("Date");
    public static By genderRadioElements = By.name("gender");
    public static By agreeToTerms = By.xpath("//input[@type='checkbox']");
    public static By submitButton = By.xpath("//input[@type='submit']");
}
