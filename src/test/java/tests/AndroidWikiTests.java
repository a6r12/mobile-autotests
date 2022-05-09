package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidWikiTests extends TestBase {

    @Tag("selenide")
    @Test
    void searchTest() {

//        step("Skip Language Selection", () ->
//                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("gulag");
        });
        step("Verify content found", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));

    }

    @Tag("selenide")
    @Test
    void verifyNewsTest() {
        step("Verify news page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_title"))
                    .shouldHave(Condition.text("In the news"));
        });
    }
}
