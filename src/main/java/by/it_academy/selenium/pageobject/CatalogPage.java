package by.it_academy.selenium.pageobject;

import by.it_academy.selenium.framework.AbstractPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends AbstractPage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(), '%s')]";
    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";

    public String getCategoriesInsideOfComputersAndNets() {
        return "//*[@class='catalog-navigation-list__aside-title']";
    }

    public String getCatalogClassifierLinks() {
        return "//*[@class='catalog-navigation-classifier__item-title-wrapper']";
    }

    public List<String> getElementsInsideCategory(String str) {
        return $$x(str).shouldBe(CollectionCondition.sizeGreaterThan(1), ofSeconds(45)).texts();
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(Condition.visible, ofSeconds(45))
                .click();
        return this;
    }

    public CatalogPage selectCategory(String category) {
        $x(String.format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category))
                .shouldBe(Condition.visible, ofSeconds(45))
                .click();
        return this;
    }
}