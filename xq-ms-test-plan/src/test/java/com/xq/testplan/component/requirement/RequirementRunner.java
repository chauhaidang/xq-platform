package com.xq.testplan.component.requirement;

import com.intuit.karate.junit5.Karate;

public class RequirementRunner {
    @Karate.Test
    Karate testRequirements() {
        return Karate.run("requirements").relativeTo(getClass());
    }
}
