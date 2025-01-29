package com.xq;

public class ConfigManager {
    private final Config config;

    private ConfigManager() {
        ConfigReader configReader = new ConfigReader();
        config = configReader.loadConfig();
    }

    private static class ConfigManagerSingleton {
        private static final ConfigManager INSTANCE = new ConfigManager();
    }
    public static ConfigManager getInstance() {
        return ConfigManagerSingleton.INSTANCE;
    }

    public Config getConfig() {
        return config;
    }
}
