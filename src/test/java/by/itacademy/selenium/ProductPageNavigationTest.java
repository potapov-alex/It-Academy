package by.itacademy.selenium;

import by.itacademy.selenium.navigation.OnlinerNavigation;
import by.itacademy.selenium.page_object.OnlinerHeader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductPageNavigationTest extends BaseTest {
    private OnlinerHeader onlinerHeader = new OnlinerHeader();

    @BeforeAll
    static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testUserIsAbleToNavigateToProductPageViaCatalog() {
        boolean isProductPageTitleDisplayed = onlinerHeader
                .clickOnCatalogNavigationLink()
                .clickOnCatalogClassifierLink("Электроника")
                .selectCategory("Аудиотехника")
                .selectProduct("Наушники")
                .isProductPageTitleDisplayed();
        assertThat(isProductPageTitleDisplayed)
                .as("Product page title is not displayed via catalog link navigation")
                .isTrue();
    }

   /*  @AfterAll
   public static void closeBrowser() {
        onlinerHeader.closeBrowser();
    } */
}
