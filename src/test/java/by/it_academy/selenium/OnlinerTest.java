package by.it_academy.selenium;

import by.it_academy.selenium.navigation.HomePageNavigation;
import by.it_academy.selenium.pageobject.CatalogPage;
import by.it_academy.selenium.pageobject.Header;
import by.it_academy.selenium.pageobject.ProductPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerTest {

    private Header onlinerHeader = new Header();
    private CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToOnliner() {
        HomePageNavigation.openHomePage("https://www.onliner.by/");
    }

    @BeforeEach
    public void navigateToCatalogOfOnliner() {
        onlinerHeader.clickOnMainNavigationLink("Каталог");
    }


    @Test
    public void getCatalogueSections() {
        List<String> elements = new ArrayList<>();
        elements.add("Электроника");
        elements.add("Компьютеры и сети");
        elements.add("Бытовая техника");
        elements.add("Стройка и ремонт");
        elements.add("Дом и сад");
        elements.add("Авто и мото");
        elements.add("Красота и спрот");
        elements.add("Детям и мамам");
        elements.add("Работа и офис");
        elements.add("Еда");

        List<String> elementsOfOnlinerCatalogPage = navigateToCategoryComputersAndNets()
                .getElementsInsideCategory(catalogPage.getCatalogClassifierLinks());
        assertThat(elementsOfOnlinerCatalogPage)
                .allMatch(n -> n.equals(elements));
    }

    @Test
    public void testCategoryComputersAndNetsHasElements() {
        List<String> categoriesOfComputersAndNets = navigateToCategoryComputersAndNets()
                .getElementsInsideCategory(catalogPage.getCategoriesInsideOfComputersAndNets());
        assertThat(categoriesOfComputersAndNets)
                .anyMatch(n -> n.equals("Ноутбуки, компьютеры, мониторы"))
                .anyMatch(n -> n.equals("Комплектующие"))
                .anyMatch(n -> n.equals("Хранение данных"))
                .anyMatch(n -> n.equals("Сетевое оборудование"));
    }

    @Test
    public void testProductsAndDescriptionsOfAccessoriesAreNotEmpty() {
        List<String> productsAndDescriptionsOfAccessories = navigateToCategoryComputersAndNets()
                .selectCategory("Комплектующие")
                .getElementsInsideCategory(ProductPage.PRODUCTS_INSIDE_OF_ACCESSORIES);
        assertThat(productsAndDescriptionsOfAccessories)
                .noneMatch(Objects::isNull);
    }

    private CatalogPage navigateToCatalogPage() {
        return onlinerHeader.clickOnMainNavigationLink("Каталог");
    }

    private CatalogPage navigateToCategoryComputersAndNets() {
        return catalogPage.clickOnCatalogClassifierLink("Компьютеры и\u00A0сети");
    }
}