package tests.ios;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.UiElements;
import tests.TestBase;

@Feature("Selenide-appium iOS")
@Tag("ios")
public class IosTests extends TestBase {
    final UiElements uiElements = new UiElements();

    @Test
    @DisplayName("Enter word and check in app UI Elements")
    void testCalcOne() {
        uiElements.clickOnButton()
                .enterText()
                .checkText();
    }
}