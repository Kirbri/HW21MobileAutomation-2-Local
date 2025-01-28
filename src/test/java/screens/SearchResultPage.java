package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SearchResultPage {
    final SelenideElement searchKeyWords = $(id("org.wikipedia.alpha:id/page_list_item_title")),
            errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    public SearchResultPage openFirstSearchResult() {
        searchKeyWords.click();
        return this;
    }

    public SearchResultPage checkTextOnPageResult() {
        errorText.shouldHave(text("An error occurred"));
        return this;
    }
}