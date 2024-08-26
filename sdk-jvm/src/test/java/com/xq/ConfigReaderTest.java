package com.xq;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigReaderTest {
    @Test
    void shouldReturnCorrectConfig() throws Exception {
        ConfigReader reader = new ConfigReader();
        Properties prop = new Properties();
        prop.setProperty("sdk.version", "1.1.1");
        Config config = reader.loadConfig(prop);
        assert config.getSdkVersion().equals("1.1.1");
    }

    @Test
    void shouldReturnCorrectDefaultConfig() throws Exception {
        ConfigReader reader = new ConfigReader();
        Config config = reader.loadConfig();
        assertEquals("1.1.1", config.getSdkVersion());
        assertEquals("localhost", config.getApiGateway());
        assertEquals("abc", config.getMobileAndroidAppPath());
        assertEquals("android", config.getMobilePlatform());
        assertEquals("123", config.getMobilePlatformVersion());
        assertEquals("456", config.getMobileDeviceName());
        assertEquals("app.act", config.getMobileAppWaitActivity());
        assertEquals("http://localhost:4723", config.getMobileAppiumUrl());
        assertEquals(120, config.getMobileCmdTimeout());
    }

    @Test
    void shouldThrowWhenPropNotAvailable() {
        assertThrows(RuntimeException.class, () -> {
            ConfigReader reader = new ConfigReader();
            reader.readConfigValue(new Properties(), "abc");
        }, "config reader does not throw runtime exception");
    }

    @Test
    void shouldReturnValueWhenKeyExists() {
        ConfigReader reader = new ConfigReader();
        Properties properties = new Properties();
        properties.setProperty("abc", "1.1.1");
        assertEquals("1.1.1", reader.readConfigValue(properties, "abc"));
    }

    @Test
    void shouldThrowWhenKeyNotFound() {
        assertThrows(RuntimeException.class, () -> {
            ConfigReader reader = new ConfigReader();
            reader.readConfig("config2.properties");
        }, "config reader does not throw runtime exception");
    }

    @Test
    void shouldReturnCorrectProp() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("sdk.version", "1.1.1");
        prop.setProperty("sdk.version2", "");
        prop.setProperty("api.gateway", "localhost");
        prop.setProperty("mobile.androidAppPath", "abc");
        prop.setProperty("mobile.platform", "android");
        prop.setProperty("mobile.platformVersion", "123");
        prop.setProperty("mobile.deviceName", "456");
        prop.setProperty("mobile.appWaitActivity", "app.act");
        prop.setProperty("mobile.appiumUrl", "http://localhost:4723");
        prop.setProperty("mobile.cmdTimeout", "120");
        assertEquals(prop, new ConfigReader().readConfig());
    }

    @Test
    void shouldThrowWhenFileNotFound() {
        assertThrows(RuntimeException.class, () -> {
            new ConfigReader().readConfig("non_existing_file.properties");
        }, "config reader does not throw io exception");
    }

    @Test
    void shouldReturnTrueWhenKeyExist() {
        assertTrue(new ConfigReader().isKeyExisting(new ConfigReader().readConfig(), "sdk.version"));
    }

    @Test
    void shouldReturnFalseWhenKeyNotExist() {
        assertFalse(new ConfigReader().isKeyExisting(new ConfigReader().readConfig(), "sdk.version3"));
    }
}
