package by.itacademy.selenium.page_object;

import by.itacademy.selenium.framework.AbstractPage;
import org.openqa.selenium.By;

public class ProductPage extends AbstractPage {
    private static final By PRODUCT_PAGE_TITLE = By.xpath("//h1[contains(@class, ' js-schema-header_title')]");

    public boolean isProductPageTitleDisplayed() {
        return isElementDisplayed(PRODUCT_PAGE_TITLE);
    }
}
