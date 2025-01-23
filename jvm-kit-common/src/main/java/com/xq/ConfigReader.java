package com.xq;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static com.xq.Constant.TEST_RESOURCE_DIR;

public class ConfigReader {
    public Properties readConfig(String fileName) {
        String configPath = Paths.get(TEST_RESOURCE_DIR, fileName).toString();
        if (!new File(configPath).exists()) {
            throw new RuntimeException("xq.properties not found!");
        }
        File file = new File(configPath);
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(file.getAbsolutePath())) {
            props.load(in);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("can't read config", e.getCause());
        }

        return props;
    }

    public Properties readConfig() {
        return readConfig(Constant.DEFAULT_CONFIGURATION_FILE);
    }

    public Config loadConfig(Properties props) {
        Config conf = new Config();
        conf.setSdkVersion(props.getProperty("sdk.version"));
        return conf;
    }

    public boolean isKeyExisting(Properties props, String key) {
        return props.containsKey(key);
    }

    /**
     * Used to read mandatory field in properties file
     *
     * @param props Properties loaded
     * @param key   Properties key
     * @return value
     */
    public String readConfigValue(Properties props, String key) {
        if (!isKeyExisting(props, key)) {
            throw new RuntimeException(String.format("Error reading config value: key '%s' not found!", key));
        }
        return props.getProperty(key);
    }

    public Config loadConfig() {
        Config conf = new Config();
        Properties props = readConfig();
        conf.setSdkVersion(props.getProperty("sdk.version", "0.0.0"));
        conf.setApiGateway(props.getProperty("api.gateway", "localhost"));

        if (isKeyExisting(props, "mobile.platform")) {

            conf.setMobilePlatform(readConfigValue(props, "mobile.platform"));
            conf.setMobilePlatformVersion(readConfigValue(props, "mobile.platformVersion"));
            conf.setMobileAppiumUrl(readConfigValue(props, "mobile.appiumUrl"));
            conf.setMobileCmdTimeout(Integer.parseInt(readConfigValue(props, "mobile.cmdTimeout")));
            conf.setMobileServerInstallTimeout(Integer.parseInt(readConfigValue(props, "mobile.serverInstallTimeout")));

            //Android
            conf.setMobileAppWaitActivity(readConfigValue(props, "mobile.appWaitActivity"));
            conf.setMobileAppPackage(readConfigValue(props, "mobile.appPackage"));
            conf.setMobileAndroidAppPath(
                    isKeyExisting(props, "mobile.androidAppPath") ?
                            readConfigValue(props, "mobile.androidAppPath") : Constant.DEFAULT_ANDROID_APP_PATH);
            conf.setMobileDeviceName(readConfigValue(props, "mobile.deviceName"));

            //IOS
            conf.setMobileIOSAppPath(isKeyExisting(props, "mobile.iosAppPath") ?
                    readConfigValue(props, "mobile.iosAppPath") : Constant.DEFAULT_IOS_APP_PATH);
            conf.setMobileDeviceUdid(readConfigValue(props, "mobile.udid"));
        }

        return conf;
    }
}