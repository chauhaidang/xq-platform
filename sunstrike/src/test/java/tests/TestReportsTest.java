package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.xq.helper.PlatformLocator.byLabel;

public class TestReportsTest extends BaseTestFixture {
    @Test
    void testTestReportsAreShown() {
        $(Home.LABEL_TEST_REPORTS).tap();
        $(Header.LABEL_TEST_REPORTS).shouldBe(visible);
        $(byLabel("Test Reports Are Coming Soon!")).shouldBe(visible);
    }
}
