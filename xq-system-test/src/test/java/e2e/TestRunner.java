package e2e;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRunner {
    @Test
    void testThatUserCanManageRequirement() {
        Results results = Runner.path("classpath:e2e")
                .outputCucumberJson(true)
                .outputHtmlReport(true)
                .reportDir("build/karate-reports")
                .parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
