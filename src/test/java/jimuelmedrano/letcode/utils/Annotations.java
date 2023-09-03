package jimuelmedrano.letcode.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.Instant;

public class Annotations {
    Instant startTime;
    Instant endTime;
    public DriverSetup ds = new DriverSetup();
    @BeforeSuite
    public void beforeAll() {
        System.out.println("Starting Test...");
        //Execution Start Time
        startTime = Instant.now();
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
        System.out.println("Test Done!");
        endTime = Instant.now();
        long time = Duration.between(startTime, endTime).toSeconds();
        System.out.println("RUN TIME: " + time +"s");
    }
}
