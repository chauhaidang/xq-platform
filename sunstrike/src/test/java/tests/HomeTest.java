package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomeTest extends BaseTestFixture {
    @Test
    void testHomeScreenIsShown() {
        $(Header.LABEL_HOME).shouldBe(visible);
        $(Home.LABEL_TEST_PLANS).shouldBe(visible);
        $(Home.LABEL_TEST_CASES).shouldBe(visible);
        $(Home.LABEL_TEST_REPORTS).shouldBe(visible);
    }
}
