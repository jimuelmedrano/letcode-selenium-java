package jimuelmedrano.letcode.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    public WebDriver driver;
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if(FrameworkConstants.isHeadless){
            options.addArguments("--headless=new");
        }
        //options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }
}
