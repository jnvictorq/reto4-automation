package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Evita el bug de maximize() en Chrome 148
        driver.manage().window().setSize(new Dimension(1920, 1080));

        return driver;
    }
}
