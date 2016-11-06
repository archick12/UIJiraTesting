package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory {

    public static WebDriver createInstance(String browserName) {
        URL hostURL = null;
        try {
            hostURL = new URL("http://192.168.0.62:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = null;

        if (browserName.toLowerCase().contains("firefox")) {
            capability = DesiredCapabilities.firefox();
        }
        if (browserName.toLowerCase().contains("internet")) {
            capability = DesiredCapabilities.internetExplorer();
        }
        if (browserName.toLowerCase().contains("chrome")) {
            capability = DesiredCapabilities.chrome();
//            capability.setBrowserName("chrome" );
//            capability.setPlatform(Platform.LINUX);
        }

        WebDriver driver = new RemoteWebDriver(hostURL, capability);
        driver.manage().window().maximize();
        return driver;
    }
}
