package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideTest extends TestBase {

    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".search-input").click();
        $("#query-builder-test").setValue("selenide/selenide").pressEnter();

        $(By.linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("#2434")).should(Condition.exist);










    }





}
