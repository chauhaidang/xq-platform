package com.xq.helper;

import com.xq.Config;
import com.xq.ConfigReader;

public class PlatformLocator {
    public record Locator(String android, String ios) {};
    public static Config config = new ConfigReader().loadConfig();
    public static String locate(String androidLocator, String iosLocator) {
       return config.getMobilePlatform().equals("android") ? androidLocator : iosLocator;
    }
}
