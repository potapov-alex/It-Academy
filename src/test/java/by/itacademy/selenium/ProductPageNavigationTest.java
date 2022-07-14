package by.itacademy.selenium;

import by.itacademy.selenium.navigation.OnlinerNavigation;
import by.itacademy.selenium.page_object.HomePage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class ProductPageNavigationTest {

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testUserIsAbleToProductPageViaLinkCatalog(){
        new HomePage().clickONCatalogLinc();
    }
}
