package by.itacademy.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverDiscovery {
    private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();

    public WebDriverDiscovery() {
        if (remoteWebDriverThreadLocal.get() == null) {
            startBrowser();
        }
    }

    private void startBrowser() {
        setWebBrowser(new ChromeDriver());
    }

    private static void setWebBrowser(RemoteWebDriver driver) {
        remoteWebDriverThreadLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public WebDriver getWebdriver() {
        return remoteWebDriverThreadLocal.get();
    }
}