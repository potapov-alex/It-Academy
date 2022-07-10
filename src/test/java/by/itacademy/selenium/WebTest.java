package by.itacademy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest {
    String DRIVER_PATH = "F:\\javaCoding\\itacademy\\src\\test\\java\\by\\itacademy\\selenium\\resources\\chromedriver.exe";
    private WebDriver driver;

    @BeforeClass
    public void driverInit() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void OnlinerOpenTest() {
        driver.get("https://catalog.onliner.by");
        //assertThat(driver.getTitle()).as("browser title does not contain курсы").contains("Каталог");
        //WebElement element = driver.findElement(By.xpath(""));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='catalog-navigation-classifier__item ']"));

        assertThat(getTextFromWebElements(elements)).as("not contain").contains("Электроника");

        driver.close();
        driver.quit();
    }

    private List<String> getTextFromWebElements(List<WebElement> elements) {
        return elements.stream().map(el -> el.getText()).collect(Collectors.toList());
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}