package repository.object;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.selector.CombinedBy.android;
import static com.xq.helper.PlatformLocator.byAndroidResourceId;

public interface NavigationBar {
    By HOME_NAV = android(byAndroidResourceId("bottom-nav-home"));
}
