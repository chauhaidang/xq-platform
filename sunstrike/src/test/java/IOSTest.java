import com.xq.mobile.BaseTestFixture;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class IOSTest extends BaseTestFixture {
    By inputEntity = AppiumBy.accessibilityId("input-entity");
    By buttonAddNewEntity = AppiumBy.accessibilityId("ADD NEW ENTITY");
    By buttonAdd = AppiumBy.accessibilityId("Add");

    @Test
    void testCreateAnEntity() {
        String firstInput = "First entity";
        $(buttonAddNewEntity).click();
        $(inputEntity).shouldBe(visible);

        submitNewEntity(firstInput);
        verifyEntityIsShown("0", firstInput);
    }

    @Test
    void testCreateMultipleEntities() {
        String firstInput = "First entity";
        String secondInput = "Second entity";

        $(buttonAddNewEntity).click();
        submitNewEntity(firstInput);
        verifyEntityIsShown("0", firstInput);

        $(buttonAddNewEntity).click();
        submitNewEntity(secondInput);
        verifyEntityIsShown("0", firstInput);
        verifyEntityIsShown("1", secondInput);
    }

    private void submitNewEntity(String entityName) {
        $(inputEntity).sendKeys(entityName);
        $(inputEntity).shouldHave(exactValue(entityName));
        $(buttonAdd).click();
    }

    private void verifyEntityIsShown(String index, String expectedName) {
        var entityItem = AppiumBy.accessibilityId("item-entity-%s".formatted(index));
        $(entityItem).shouldBe(visible);
        $(entityItem).shouldHave(exactText(expectedName));
    }
}

