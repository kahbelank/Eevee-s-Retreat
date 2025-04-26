package com.eevee.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindBookingPageTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testFindBookingPageContent() {
        driver.get("http://127.0.0.1:5173/find-booking");

        // Check navigation items
        Assertions.assertTrue(driver.getPageSource().contains("Eevee's Retreat"));
        Assertions.assertTrue(driver.getPageSource().contains("Browse all rooms"));
        Assertions.assertTrue(driver.getPageSource().contains("Find my booking"));
        Assertions.assertTrue(driver.getPageSource().contains("Account"));

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
