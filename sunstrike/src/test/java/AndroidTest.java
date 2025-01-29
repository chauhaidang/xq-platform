import com.xq.mobile.BaseTestFixture;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AndroidTest extends BaseTestFixture {
    By inputEntity = AppiumBy.xpath("//*[@resource-id='input-entity']");
    By buttonAddNewEntity = AppiumBy.accessibilityId("ADD NEW ENTITY");
    By buttonAdd = AppiumBy.accessibilityId("ADD");

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
        $(inputEntity).shouldHave(exactText(entityName));
        $(buttonAdd).click();
    }

    private void verifyEntityIsShown(String index, String expectedName) {
        var entityItem = AppiumBy.xpath("//*[@resource-id='item-entity-%s']".formatted(index));
        $(entityItem).$("android.widget.TextView").shouldBe(visible);
        $(entityItem).$("android.widget.TextView").shouldHave(exactText(expectedName));
    }
}
