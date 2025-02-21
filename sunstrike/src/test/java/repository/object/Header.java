package repository.object;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.xq.helper.PlatformLocator.byAndroidContentDesc;
import static com.xq.helper.PlatformLocator.byVisibleText;

public interface Header {
    By LABEL_HOME = byVisibleText("Home");
    By LABEL_TEST_PLANS = byVisibleText("Test Plans");
    By LABEL_TEST_CASES = byVisibleText("Test Cases");
    By LABEL_TEST_REPORTS = byVisibleText("Test Reports");

    CombinedBy BUTTON_BACK = CombinedBy
            .android(byAndroidContentDesc("Navigate up"))
            .ios(AppiumBy.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeButton"));
}
