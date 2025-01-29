package repository.object;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;

import java.util.function.Function;

public interface Home {
    CombinedBy TITLE = CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='test-data-title']"))
            .ios(AppiumBy.accessibilityId("test-data-title"));

    CombinedBy BOTTOM_NAV = CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='test-data-footer']"))
            .ios(AppiumBy.accessibilityId("test-data-footer"));

    Function<Integer, CombinedBy> ITEM = (index) -> CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='item-entity-%s']".formatted(index)))
            .ios(AppiumBy.accessibilityId("item-entity-%s".formatted(index)));
}
