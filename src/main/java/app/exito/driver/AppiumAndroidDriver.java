package app.exito.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class AppiumAndroidDriver {

    public static AppiumDriver driver;

    public static AppiumDriver initializeDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName","sdk_gphone_x86");
            capabilities.setCapability("udid","emulator-5554");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("appPackage","com.exito.appcompania");
            capabilities.setCapability("appActivity","com.exito.appcompania.views.initialaccess.activities.SplashActivity");
            capabilities.setCapability("noReset","true");
            capabilities.setCapability("platformVersion","11");

            try {
                driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
