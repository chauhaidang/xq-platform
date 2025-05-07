package e2e;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiEndToEndTest {
    @Test
    void testThatUserCanManageRequirement() {
        Results results = Runner.path("classpath:e2e/manage-requirement.feature").parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
