package tests;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import com.xq.mobile.BaseTestFixture;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import repository.object.Header;
import repository.object.Home;
import repository.object.NavigationBar;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.xq.helper.PlatformLocator.byVisibleText;
import static helper.Common.logDomTree;

public class HomeTest extends BaseTestFixture {
    @Test
    void testHomeScreenIsShown() {
        $(Header.LABEL_HOME).shouldBe(visible);
        $(Home.LABEL_TEST_PLANS).shouldBe(visible);
        $(Home.LABEL_TEST_CASES).shouldBe(visible);
        $(Home.LABEL_TEST_REPORTS).shouldBe(visible);
    }

    @Test
    void testThatUserCanGoBackToHomeScreen() throws IOException {
        $(Home.LABEL_TEST_CASES).shouldBe(visible, Duration.ofSeconds(30)).click();
        $(Header.BUTTON_BACK).shouldBe(visible);

        logDomTree(WebDriverRunner.source());

        $(NavigationBar.HOME_NAV).shouldBe(visible).click();
        $(Header.LABEL_HOME).shouldBe(visible);

        $(Home.LABEL_TEST_PLANS).shouldBe(visible).click();
        $(NavigationBar.HOME_NAV).shouldBe(visible).click();

        $(Home.LABEL_TEST_REPORTS).shouldBe(visible).click();
        $(Header.LABEL_TEST_REPORTS).shouldBe(visible);

        $(NavigationBar.HOME_NAV).shouldBe(visible).click();
        $(Home.LABEL_TEST_PLANS).shouldBe(visible);
        $(Home.LABEL_TEST_CASES).shouldBe(visible);
        $(Home.LABEL_TEST_REPORTS).shouldBe(visible);
    }
}
