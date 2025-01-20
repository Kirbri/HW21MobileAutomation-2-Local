package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/credentials.properties",
})

public interface LoginConfig extends Config {

    @Key("browserstack.user")
    String getProfileLogin();

    @Key("browserstack.key")
    String getProfilePassword();
}
