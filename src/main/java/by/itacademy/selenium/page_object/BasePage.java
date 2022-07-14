package by.itacademy.selenium.page_object;

import by.itacademy.selenium.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private final WebDriver driver;
    private WebDriverDiscovery webDriverDiscovery;

    public BasePage() {
        this.webDriverDiscovery = new WebDriverDiscovery();
        this.driver = webDriverDiscovery.getWebdriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void navigate(String url){
        driver.get(url);
    }
}