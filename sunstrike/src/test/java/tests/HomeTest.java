package tests;

import com.xq.mobile.BaseTestFixture;
import org.testng.annotations.Test;
import repository.object.Home;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomeTest extends BaseTestFixture {
    @Test
    void testHomeScreenIsShown() {
        $(Home.TITLE).shouldBe(visible);
        $(Home.ITEM.apply(1)).shouldBe(visible);
        $(Home.ITEM.apply(20)).scrollTo().shouldBe(visible);
        $(Home.BOTTOM_NAV).shouldBe(visible);
    }
}
