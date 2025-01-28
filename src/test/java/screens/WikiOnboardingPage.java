package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class WikiOnboardingPage {
    SelenideElement onboardingPageIndicator2 = $(id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$(className("android.widget.LinearLayout"), 1),
            onboardingPageIndicator3 = $(id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$(className("android.widget.LinearLayout"), 2),
            onboardingPageIndicator4 = $(id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).$(className("android.widget.LinearLayout"), 3),
            primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView"));

    public WikiOnboardingPage secondOnboardingPage() {
        onboardingPageIndicator2.click();
        return this;
    }

    public WikiOnboardingPage thirdOnboardingPage() {
        onboardingPageIndicator3.click();
        return this;
    }

    public WikiOnboardingPage fourthOnboardingPage() {
        onboardingPageIndicator4.click();
        return this;
    }

    public WikiOnboardingPage checkText(String texts) {
        primaryTextView.shouldHave(text(texts));
        return this;
    }
}