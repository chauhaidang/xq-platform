package com.xq.accounts.component.requirement;

import com.intuit.karate.junit5.Karate;

public class RequirementRunner {
    @Karate.Test
    Karate run() {
        return Karate.run().relativeTo(getClass());
    }
}
