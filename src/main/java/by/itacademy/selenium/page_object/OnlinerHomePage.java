package by.itacademy.selenium.page_object;

import by.itacademy.selenium.framework.AbstractPage;
import org.openqa.selenium.By;

public class OnlinerHomePage extends AbstractPage {
    private static final By TILES_OUTER_COMPONENT = By.xpath("//*[contains(@class, 'b-tiles-outer')]");
    private static final By CATALOG_LINK = By.xpath("//a[contains(@href, 'catalog.onliner.by')]");
    private static final By CATALOG_SUPERPRICE_LINK =
            By.xpath("//*[contains(@class, 'main-page-catalog-layer')]//a[contains(@href, 'superprice')]");

    public boolean isElementDisplayed() {
        return isElementDisplayed(TILES_OUTER_COMPONENT);
    }

    public CatalogPage clickOnCatalogLink() {
        waitForElementVisible(CATALOG_LINK).click();
        return new CatalogPage();
    }
}
