package by.itacademy.selenium.page_object;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private static final String CATALOG_LINK = "//*[contains(@class, 'main-navigation__text') and contains(text(), '%S')]";


    waitForElementVisible(By.xpath(CATALOG_LINK));
}
