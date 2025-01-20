package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UiElements {

    final SelenideElement textButton = $(AppiumBy.accessibilityId("Text Button"));
    final SelenideElement textInput = $(AppiumBy.accessibilityId("Text Input"));
    final SelenideElement textOutput = $(AppiumBy.accessibilityId("Text Output"));

    public UiElements clickOnButton() {
        textButton.click();
        return this;
    }

    public UiElements enterText() {
        textInput.sendKeys("hello@browserstack.com" + "\n");
        return this;
    }

    public UiElements checkText() {
        textOutput.should(text("hello@browserstack.com"));
        return this;
    }
}
