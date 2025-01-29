package com.xq.mobile;

import com.codeborne.selenide.Configuration;
import com.xq.ConfigManager;
import com.xq.Constant;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;
import static com.xq.mobile.AppHelper.installApp;
import static com.xq.mobile.AppHelper.openApp;

public class BaseTestFixture {
    public BaseTestFixture() {
        Configuration.browserSize = null;
        Configuration.browser = ConfigManager.getInstance().getConfig().getMobilePlatform().equals("android")
                ? AndroidDriverProvider.class.getName()
                : IOSDriverProvider.class.getName();
        Configuration.timeout = Constant.DEFAULT_DRIVER_TIMEOUT;
    }

    protected void beforeEachMethod() {
        closeWebDriver();
        launchApp();
        installApp();
        openApp();
    }

    @BeforeMethod
    protected void setUp() {
        beforeEachMethod();
    }
}
