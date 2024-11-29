package com.xq;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@IncludeTags("ha | hi")
public class TestRunner {
}
