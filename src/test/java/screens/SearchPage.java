package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {
    final SelenideElement searchKeyWords = $(id("org.wikipedia.alpha:id/search_src_text"));
    final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public SearchPage searchValue(String value) {
        searchKeyWords.sendKeys(value);
        return this;
    }

    public SearchPage checkCountResult() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }
}