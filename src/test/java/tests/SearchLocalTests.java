package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.WikiOnboardingPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium local Android tests")
@Tag("emulation")
@Tag("local")
public class SearchLocalTests extends TestBase {
    WikiOnboardingPage wikiOnboardingPage = new WikiOnboardingPage();

    @Disabled
    @Test
    void successfulSearchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("local")
    @DisplayName("Open page wikipedia onboarding")
    void successfulWikiTest() {
        step("First page on onboarding", () -> {
            wikiOnboardingPage.checkText("The Free Encyclopedia\n…in over 300 languages");
        });

        step("Second page on onboarding", () -> {
            wikiOnboardingPage.secondOnboardingPage();
            wikiOnboardingPage.checkText("New ways to explore");
        });

        step("Third page on onboarding", () -> {
            wikiOnboardingPage.thirdOnboardingPage();
            wikiOnboardingPage.checkText("Reading lists with sync");
        });

        step("Fourth page on onboarding", () -> {
            wikiOnboardingPage.fourthOnboardingPage();
            wikiOnboardingPage.checkText("Data & Privacy");
        });
    }
}