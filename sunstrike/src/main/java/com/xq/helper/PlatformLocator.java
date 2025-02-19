package com.xq.helper;

import com.codeborne.selenide.appium.selector.CombinedBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;

public class PlatformLocator {

    public static By byLabel(String label) {
       return CombinedBy
               .android(byAttribute("content-desc", label))
               .ios(byAttribute("label", label));
    }
}
