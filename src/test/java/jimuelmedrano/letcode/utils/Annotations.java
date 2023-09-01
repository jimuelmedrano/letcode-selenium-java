package jimuelmedrano.letcode.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class Annotations {
    public DriverSetup ds = new DriverSetup();
    @BeforeSuite
    public void beforeAll() {
        System.out.println("Starting Test...");
        //TODO: start time
    }
    @BeforeClass
    public void setUp() {
        ds.setUpDriver();
    }
    @AfterClass
    public void teardown() {
        ds.driver.quit();
    }
    @AfterSuite
    public void afterALl() {
        ds.driver.quit();
        System.out.println("Test Done");
        //TODO: print difference of start and end time to get run time
    }
}
