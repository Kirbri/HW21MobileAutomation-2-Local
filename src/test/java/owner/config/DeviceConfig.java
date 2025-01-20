package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${platform}.properties",
})

public interface DeviceConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("platform.name")
    String getPlatformName();

    @Key("platform.version")
    String getPlatformVersion();

    @Key("browserstack.app")
    String getBrowserstackApp();
}
