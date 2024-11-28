package com.xq.mobile;

import com.codeborne.selenide.WebDriverProvider;
import com.xq.Config;
import com.xq.ConfigReader;
import com.xq.Constant;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
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
public class IOSDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    @CheckReturnValue
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ConfigReader configReader = new ConfigReader();
        Config config = configReader.loadConfig();

        File app = new File(Constant.USER_DIRECTORY + config.getMobileIOSAppPath());
        XCUITestOptions options = new XCUITestOptions();
        options.merge(capabilities);
        options.setApp(app.getAbsolutePath());
        options.setOrientation(ScreenOrientation.PORTRAIT);
        options.setAutomationName(Constant.IOS_AUTOMATION_NAME);
        options.setPlatformName("iOS");
        options.setUdid(config.getMobileDeviceUdid());
        options.setNewCommandTimeout(Duration.ofSeconds(config.getMobileCmdTimeout()));

        try {
            return new IOSDriver(new URL(config.getMobileAppiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
