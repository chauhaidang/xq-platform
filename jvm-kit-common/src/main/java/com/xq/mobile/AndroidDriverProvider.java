package com.xq.mobile;

import com.codeborne.selenide.WebDriverProvider;
import com.xq.Config;
import com.xq.ConfigReader;
import com.xq.Constant;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@ParametersAreNonnullByDefault
public class AndroidDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    @CheckReturnValue
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ConfigReader configReader = new ConfigReader();
        Config config = configReader.loadConfig();

        File app = new File(Constant.USER_DIRECTORY + config.getMobileAndroidAppPath());
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setApp(app.getAbsolutePath());
        options.setPlatformName("Android");
        options.setPlatformVersion(config.getMobilePlatformVersion());
        options.setDeviceName(config.getMobileDeviceName());
        options.setOrientation(ScreenOrientation.PORTRAIT);
        options.setAutomationName(Constant.ANDROID_AUTOMATION_NAME);
        options.setAppWaitActivity(config.getMobileAppWaitActivity());
        options.setAppPackage(config.getMobileAppPackage());
        options.setNewCommandTimeout(Duration.ofSeconds(config.getMobileCmdTimeout()));
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(config.getMobileServerInstallTimeout()));


        try {
            return new AndroidDriver(new URL(config.getMobileAppiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
