package by.itacademy.selenium;

public class WebTest {


    /*
    String DRIVER_PATH = "/chromedriver.exe";
    private WebDriver driver;

    @BeforeAll
    public void driverInit() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void OnlinerCatalogTest() {
        driver.get("https://catalog.onliner.by");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='catalog-navigation-classifier__item ']"));

        assertThat(getTextFromWebElements(elements)).as("not contain").contains("Электроника");

        driver.close();
        driver.quit();
    }

    private List<String> getTextFromWebElements(List<WebElement> elements) {
        return elements.stream().map(el -> el.getText()).collect(Collectors.toList());
    }

    @AfterAll
    public void closeBrowser() {
        driver.quit();
    }
    */
}