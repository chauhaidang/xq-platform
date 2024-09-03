package com.xq;

import lombok.Data;

@Data
public class Config {
    private String sdkVersion;
    private String apiGateway;
    private String mobileAndroidAppPath;
    private String mobilePlatform;
    private String mobilePlatformVersion;
    private String mobileDeviceName;
    private String mobileAppWaitActivity;
    private int mobileCmdTimeout;
    private String mobileAppiumUrl;
    private String mobileIOSAppPath;
    private String mobileDeviceUdid;
}
