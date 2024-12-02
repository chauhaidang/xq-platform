package com.xq;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@IncludeTags("ha | hi")
@ConfigurationParameters({
//        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.xq"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.xq.reststep")
})
public class TestRunner {
}
