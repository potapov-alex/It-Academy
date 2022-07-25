package by.it_academy.selenium.framework;

public class DriverCreatorFactory {

    public static WebDriverCreator getDriverCreator(String driverType) {
        return switch (driverType) {
            case "chrome" -> new ChromeDriverCreator();
            case "firefox" -> new FirefoxDriverCreator();
            case "remote" -> new RemoteDriverCreator();
            default -> new ChromeDriverCreator();
        };
    }
}
