package com.xq.mobile;

import com.codeborne.selenide.Configuration;
import com.xq.Constant;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class AndroidTestFixture {
    public AndroidTestFixture() {
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverProvider.class.getName();
        Configuration.timeout = Constant.DEFAULT_DRIVER_TIMEOUT;
    }
    protected void beforeEachMethod() {
        closeWebDriver();
        open();
    }

    @BeforeMethod
    protected void setUp() {
        beforeEachMethod();
    }
}
