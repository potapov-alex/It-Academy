package by.it_academy.selenium.pageobject;

import by.it_academy.selenium.framework.AbstractPage;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class Header extends AbstractPage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public CatalogPage clickOnMainNavigationLink(String link) {
        $x(String.format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(Condition.visible, ofSeconds(45))
                .click();
        return null;
    }

}