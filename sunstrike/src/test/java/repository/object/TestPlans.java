package repository.object;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;

import java.util.function.Function;

public interface TestPlans {
    Function<Integer, CombinedBy> ITEM = (index) -> CombinedBy
            .android(AppiumBy.xpath("//*[@resource-id='item-entity-%s']".formatted(index)))
            .ios(AppiumBy.accessibilityId("item-entity-%s".formatted(index)));
}
