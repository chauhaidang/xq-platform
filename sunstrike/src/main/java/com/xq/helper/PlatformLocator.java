package com.xq.helper;

import com.codeborne.selenide.appium.selector.CombinedBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;

public class PlatformLocator {

    public static By byVisibleText(String label) {
       return CombinedBy
               .android(byText(label))
               .ios(byiOSLabel(label));
    }

    public static By byiOSLabel(String label) {
       return byAttribute("label", label);
    }

    public static By byAndroidContentDesc(String content) {
        return byAttribute("content-desc", content);
    }
}
