package repository.object;

import org.openqa.selenium.By;

import static com.xq.helper.PlatformLocator.byVisibleText;

public interface Home {
    By LABEL_TEST_PLANS= byVisibleText("Test Plans");
    By LABEL_TEST_CASES = byVisibleText("Test Cases");
    By LABEL_TEST_REPORTS = byVisibleText("Test Reports");
}
