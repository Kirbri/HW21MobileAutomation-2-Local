package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UiElementsPage {

    final SelenideElement textButton = $(AppiumBy.accessibilityId("Text Button")),
            textInput = $(AppiumBy.accessibilityId("Text Input")),
            textOutput = $(AppiumBy.accessibilityId("Text Output"));

    public UiElementsPage clickOnButton() {
        textButton.click();
        return this;
    }

    public UiElementsPage enterText() {
        textInput.sendKeys("hello@browserstack.com" + "\n");
        return this;
    }

    public UiElementsPage checkText() {
        textOutput.should(text("hello@browserstack.com"));
        return this;
    }
}