import com.xq.mobile.IOSTestFixture;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byName;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class IOSTest extends IOSTestFixture {
    @Test
    void testOpenApp() {
        $(AppiumBy.accessibilityId("ADD NEW GOAL")).shouldBe(visible);
    }
}

