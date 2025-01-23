package com.xq.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import com.codeborne.selenide.appium.AppiumNavigator;
import com.codeborne.selenide.appium.SelenideAppium;
import com.xq.Config;
import com.xq.ConfigReader;
import com.xq.Constant;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class AndroidTestFixture {
    ConfigReader configReader = new ConfigReader();
    Config config = configReader.loadConfig();
    public AndroidTestFixture() {
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverProvider.class.getName();
        Configuration.timeout = Constant.DEFAULT_DRIVER_TIMEOUT;
    }
    protected void beforeEachMethod() {
        closeWebDriver();
        open();
        AppiumDriverRunner.getAndroidDriver().installApp(
                new File(Constant.USER_DIRECTORY + config.getMobileAndroidAppPath()).getAbsolutePath());
        startActivity(config.getMobileAppPackage(), config.getMobileAppWaitActivity());
    }

    protected void startActivity(String appPackage, String appActivity) {
        Map<String, String> args = new HashMap<>();
        args.put("action", "android.intent.action.MAIN");
        args.put("component", appPackage + "/" + appActivity);
        AppiumDriverRunner.getAndroidDriver().executeScript("mobile: startActivity", args);
    }

    @BeforeMethod
    protected void setUp() {
        beforeEachMethod();
    }
}
