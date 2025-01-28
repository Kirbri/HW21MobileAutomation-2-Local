package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static owner.config.DeviceProvider.DEVICE_CONFIG;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        if (DEVICE_CONFIG.getPlatformName().equals("android")) {
            return getAndroidDriver();
        } else if (DEVICE_CONFIG.getPlatformName().equals("ios")) {
            return getIosDriver();
        } else {
            throw new IllegalArgumentException("Unknown state: support only Android or iOS.");
        }
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "autotests");
        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", DEVICE_CONFIG.getDeviceName());
        capabilities.setCapability("os_version", DEVICE_CONFIG.getPlatformVersion());
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", DEVICE_CONFIG.getBrowserstackApp());

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", DEVICE_CONFIG.getDeviceName());
        capabilities.setCapability("platformVersion", DEVICE_CONFIG.getPlatformVersion());
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", DEVICE_CONFIG.getBrowserstackApp());

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }
}