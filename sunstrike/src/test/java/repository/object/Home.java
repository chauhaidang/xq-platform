package repository.object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.*;

public interface Home {
    By LABEL_TEST_PLANS= byName("Test Plans");
    By LABEL_TEST_CASES = byName("Test Cases");
    By LABEL_TEST_REPORTS = byName("Test Reports");
}
