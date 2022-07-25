package by.it_academy.selenium.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

public class SelenideWebDriverDiscovery implements WebDriverProvider {

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
      //  String driverType = System.getProperty("driverType");
        String driverType = "chrome";
        return DriverCreatorFactory.getDriverCreator(driverType).create();
    }
}