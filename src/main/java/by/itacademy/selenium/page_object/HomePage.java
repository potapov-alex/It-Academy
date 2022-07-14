package by.itacademy.selenium.page_object;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By CATALOG_LINK = By.xpath("//*[contains(@class, 'main-navigation__text') and contains(text(), '%S')]");

    public void clickONCatalogLinc() {
        waitForElementVisible(CATALOG_LINK).click();
    }


}
