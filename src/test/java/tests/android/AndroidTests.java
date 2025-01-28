package tests.android;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.MainPage;
import screens.SearchPage;
import screens.SearchResultPage;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium Android tests")
@Tag("android")
@Tag("browserstack")
public class AndroidTests extends TestBase {
    final MainPage mainPage = new MainPage();
    final SearchPage searchPage = new SearchPage();
    final SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    @DisplayName("Open wikipedia app and search word")
    void successfulSearchAppiumTest() {
        step("Open search page", mainPage::openSearchPage);
        step("Keyword search", () ->
                searchPage.searchValue("Appium"));
        step("Verify content found", searchPage::checkCountResult);
    }

    @Test
    @DisplayName("Open wikipedia app and search word and open first link")
    void successfulSearchSelenideTest() {
        step("Open search page", mainPage::openSearchPage);
        step("Keyword search", () ->
                searchPage.searchValue("Apple"));
        step("Verify content found", searchPage::checkCountResult);
        step("Open first search link", searchResultPage::openFirstSearchResult);
        step("Verify content on page", searchResultPage::checkTextOnPageResult);
    }
}