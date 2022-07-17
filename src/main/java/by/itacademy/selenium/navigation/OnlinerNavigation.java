package by.itacademy.selenium.navigation;

import by.itacademy.selenium.page_object.OnlinerHomePage;

public class OnlinerNavigation {

    public static void navigateToOnlinerHomePage() {
    new OnlinerHomePage().navigate("https://www.onliner.by");
    }
}
