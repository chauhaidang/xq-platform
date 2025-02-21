package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.xq.helper.PlatformLocator.byVisibleText;

public class TestReportsTest extends BaseTestFixture {
    @Test
    void testTestReportsAreShown() {
        $(Home.LABEL_TEST_REPORTS).shouldBe(visible, Duration.ofSeconds(20)).click();
        $(Header.LABEL_TEST_REPORTS).shouldBe(visible);
        $(byVisibleText("Test Reports Are Coming Soon!")).shouldBe(visible);
    }
}
