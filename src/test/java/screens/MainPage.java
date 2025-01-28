package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {
    final SelenideElement searchById = $(accessibilityId("Search Wikipedia"));

    public MainPage openSearchPage() {
        searchById.click();
        return this;
    }
}