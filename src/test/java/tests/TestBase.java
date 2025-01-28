package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static owner.config.DeviceProvider.DEVICE_HOST;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        if (DEVICE_HOST.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        if (DEVICE_HOST.equals("emulation")) {
            Configuration.browser = LocalDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = "";
        if (DEVICE_HOST.equals("browserstack")) {
            sessionId = Selenide.sessionId().toString();
        }
        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();

        if (DEVICE_HOST.equals("browserstack")) {
            AttachHelper.addVideo(sessionId);
        }

    }
}