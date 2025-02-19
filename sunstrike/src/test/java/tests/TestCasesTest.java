package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.xq.helper.PlatformLocator.byLabel;

public class TestCasesTest extends BaseTestFixture {
    @Test
    void testTestCasesAreShown() {
        $(Home.LABEL_TEST_CASES).tap();
        $(Header.LABEL_TEST_CASES).shouldBe(visible);
        $(byLabel("Test Cases Are Coming Soon!")).shouldBe(visible);
    }
}
