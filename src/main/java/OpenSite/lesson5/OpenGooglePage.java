package OpenSite.lesson5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class OpenGooglePage {
    private WebDriver driver;

    /**
     * Setting up browser
     */
    @Before
    public void setUp() {
        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();

    }

    /**
     * Google page test
     * opens https://www.qasymphony.com site page
     */
    @Test
    public void openPage() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation testing");
        driver.findElement(By.xpath("//div[@jsname='VlcLAe']//input[@class='gNO89b']")).click();
        driver.findElement(By.partialLinkText("https://www.qasymphony.com")).click();

    }

    /**
     * Close browser window
     */
    @After
    public void tearDown() {
        driver.quit();
    }

}
