package repository.object;

import com.codeborne.selenide.appium.selector.CombinedBy;
import com.xq.helper.PlatformLocator;
import io.appium.java_client.AppiumBy;

public interface Home {
    CombinedBy TITLE = CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='test-data-title']"))
            .ios(AppiumBy.accessibilityId("test-data-title"));
    PlatformLocator.Locator ITEM = new PlatformLocator.Locator(
            "//*[@resource-id='item-entity-%s']", "item-entity-%s");
    String BOTTOM_NAV = "//*[@resource-id='test-data-footer']";
}
