package repository.object;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.byName;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;

public interface Header {
    By LABEL_HOME = byName("Home");
    By LABEL_TEST_PLANS = byName("Test Plans");
    By LABEL_TEST_CASES = byName("Test Cases");
    By LABEL_TEST_REPORTS = byName("Test Reports");

    CombinedBy BUTTON_BACK = CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='back-button']"))
            .ios(AppiumBy.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeButton"));
}
