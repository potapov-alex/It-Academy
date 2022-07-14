package by.itacademy.selenium.navigation;

import by.itacademy.selenium.page_object.HomePage;

public class OnlinerNavigation {

    public static void navigateToOnlinerHomePage() {
    new HomePage().navigate("https://www.onliner.by");
    }
}
