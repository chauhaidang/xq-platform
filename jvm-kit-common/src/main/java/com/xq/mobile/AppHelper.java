package com.xq.mobile;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import com.xq.ConfigManager;
import com.xq.Constant;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppHelper {
    public static void installApp() {
        if (AppiumDriverRunner.isAndroidDriver()) {
            AppiumDriverRunner.getAndroidDriver().installApp(
                    new File(Constant.USER_DIRECTORY
                            + ConfigManager.getInstance().getConfig().getMobileAndroidAppPath()).getAbsolutePath());
            return;
        }

        AppiumDriverRunner.getIosDriver().installApp(
                new File(Constant.USER_DIRECTORY
                        + ConfigManager.getInstance().getConfig().getMobileIOSAppPath()).getAbsolutePath());

    }
    public static void openApp() {
        if (AppiumDriverRunner.isAndroidDriver()) {
            startActivity(
                    ConfigManager.getInstance().getConfig().getMobileAppPackage(),
                    ConfigManager.getInstance().getConfig().getMobileAppWaitActivity());
            return;
        }
        AppiumDriverRunner.getIosDriver().activateApp(ConfigManager.getInstance().getConfig().getMobileAppPackage());
    }

    private static void startActivity(String appPackage, String appActivity) {
        Map<String, String> args = new HashMap<>();
        args.put("action", "android.intent.action.MAIN");
        args.put("component", appPackage + "/" + appActivity);
        AppiumDriverRunner.getAndroidDriver().executeScript("mobile: startActivity", args);
    }
}
