package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;
import repository.object.TestPlans;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TestPlansTest extends BaseTestFixture {
    @Test
    void testTestRequirementsAreShown() {
        $(Home.LABEL_TEST_PLANS).shouldBe(visible).click();
        $(Header.LABEL_TEST_PLANS).shouldBe(visible);
        $(Header.BUTTON_BACK).shouldBe(visible);
        $(TestPlans.ITEM.apply(1)).shouldBe(visible);
        $(TestPlans.ITEM.apply(10)).scrollTo().shouldBe(visible);

        $(Header.BUTTON_BACK).tap();
        $(Header.LABEL_HOME).shouldBe(visible);
    }
}
