package tests;

import com.xq.mobile.AndroidTestFixture;
import org.testng.annotations.Test;
import repository.object.Home;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

public class AndroidHomeTest extends AndroidTestFixture {
    @Test
    void testHomeScreenIsShown() {
        $(Home.TITLE).shouldBe(visible);
        $x(Home.ITEM.android().formatted(1)).shouldBe(visible);
        $x(Home.ITEM.android().formatted(20)).scrollTo().shouldBe(visible);
        $x(Home.BOTTOM_NAV).shouldBe(visible);
    }
}
