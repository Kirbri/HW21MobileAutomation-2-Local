package owner.config;

import org.aeonbits.owner.ConfigFactory;

public class DeviceProvider {
    public static final String DEVICE_HOST = System.getProperty("deviceHost", "emulation");
    public static final DeviceConfig DEVICE_CONFIG = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    public static final LoginConfig LOGIN_CONFIG = ConfigFactory.create(LoginConfig.class, System.getProperties());
}