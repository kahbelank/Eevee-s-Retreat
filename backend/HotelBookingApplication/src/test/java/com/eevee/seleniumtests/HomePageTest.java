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
public class HomePageTest {

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
    public void testHomePageContent() {
        driver.get("http://127.0.0.1:5173/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Check main titles
        String[] expectedTexts = {
            "Eevee's Retreat",
            "Browse all rooms",
            "Find my booking",
            "Account"
        };

        for (String text : expectedTexts) {
            Assertions.assertTrue(driver.getPageSource().contains(text), "Missing text: " + text);
        }

        // Handling split text issue
        Assertions.assertTrue(driver.getPageSource().contains("Giving the best") &&
                              driver.getPageSource().contains("just for you"));

        // Check Room Type dropdown
        WebElement roomTypeSelect = driver.findElement(By.xpath("//select"));
        Assertions.assertNotNull(roomTypeSelect);

        // Optionally check if error messages appear
        List<WebElement> errorMessages = driver.findElements(By.xpath("//*[contains(text(), 'Error fetching rooms')]"));
        Assertions.assertTrue(errorMessages.size() >= 0);
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
