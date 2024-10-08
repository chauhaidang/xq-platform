package com.xq;

import java.nio.file.FileSystems;

public interface Constant {
    String DEFAULT_CONFIGURATION_FILE = "xq.properties";
    String DEFAULT_ANDROID_APP_PATH = "/src/test/resources/xq.apk";
    String DEFAULT_IOS_APP_PATH = "/src/test/resources/xq.app";
    String ANDROID_AUTOMATION_NAME = "UiAutomator2";
    String IOS_AUTOMATION_NAME = "XCUITest";
    String USER_DIRECTORY = System.getProperty("user.dir");
    String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    String TEST_RESOURCE_DIR = USER_DIRECTORY + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "resources";
    String MAIN_RESOURCE_DIR = USER_DIRECTORY + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "resources";
    int DEFAULT_DRIVER_TIMEOUT = 1000 * 15;
}
