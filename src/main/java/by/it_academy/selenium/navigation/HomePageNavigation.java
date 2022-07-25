package by.it_academy.selenium.navigation;

import by.it_academy.selenium.pageobject.HomePage;

public class HomePageNavigation {
    public static void openHomePage(String homePage) {
        new HomePage().navigate(homePage);
    }
}