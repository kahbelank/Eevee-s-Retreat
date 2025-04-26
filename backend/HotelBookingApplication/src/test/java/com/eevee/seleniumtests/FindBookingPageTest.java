package com.eevee.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindBookingPageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().driverVersion("135.0.7049.114").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // CI/CD compatibility
        options.addArguments("--no-sandbox"); // Helps with permission issues
        options.addArguments("--disable-dev-shm-usage"); // Prevents crashes in Linux environments
        options.addArguments("--user-data-dir=/tmp/chrome-profile"); // Ensures a unique Chrome session

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    public void testFindBookingPageContent() {
        driver.get("http://127.0.0.1:5173/find-booking");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Check navigation items
        String[] navItems = {
            "Eevee's Retreat",
            "Browse all rooms",
            "Find my booking",
            "Account"
        };

        for (String text : navItems) {
            Assertions.assertTrue(driver.getPageSource().contains(text), "Missing navigation item: " + text);
        }

        // Check "Find My Booking" title
        Assertions.assertTrue(driver.getPageSource().contains("Find My Booking"));

        // Check input field for booking confirmation code
        WebElement bookingInput = driver.findElement(By.xpath("//input"));
        Assertions.assertNotNull(bookingInput);

        // Check "find booking..." button or text
        Assertions.assertTrue(driver.getPageSource().contains("find booking..."));

        // Check footer
        Assertions.assertTrue(driver.getPageSource().contains("© 2025 Eevee's Retreat"));
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
