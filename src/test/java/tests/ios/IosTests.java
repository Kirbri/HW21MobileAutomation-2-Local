package tests.ios;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.UiElementsPage;
import tests.TestBase;

@Feature("Selenide-appium iOS")
@Tag("ios")
@Tag("browserstack")
public class IosTests extends TestBase {
    final UiElementsPage uiElementsPage = new UiElementsPage();

    @Test
    @DisplayName("Enter word and check in app UI Elements")
    void testCalcOne() {
        uiElementsPage.clickOnButton()
                .enterText()
                .checkText();
    }
}