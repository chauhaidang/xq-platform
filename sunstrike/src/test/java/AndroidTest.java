import com.xq.mobile.AndroidTestFixture;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AndroidTest extends AndroidTestFixture {
    @Test
    void testOpenApp() {
        $(AppiumBy.accessibilityId("ADD NEW GOAL")).shouldBe(visible);
    }
}
