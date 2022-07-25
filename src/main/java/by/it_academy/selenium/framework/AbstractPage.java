package by.it_academy.selenium.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractPage {

    public AbstractPage() {
        Configuration.browser = SelenideWebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 200000;
        Configuration.startMaximized = true;
    }

    public void navigate(String url) {
        open(url);
    }
}