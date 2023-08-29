package jimuelmedrano.letcode.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.time.Duration;

public class Hooks {

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeSuite
    public void setupAll(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeTest
    public void setup(){

        options = new ChromeOptions();
        if(FrameworkConstants.isHeadless){
            options.addArguments("--headless=new");
        }
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.TIMEOUT));
    }

    @BeforeMethod
    public void open(){
        driver.get("https://letcode.in/test");
    }

    @AfterTest
    public void teardown() {
        System.out.println("Test Done");
        driver.quit();
    }
}
