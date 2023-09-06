package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideTest extends TestBase {

    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    public void testIssueSearch(){

        $(".search-input").click();
        $("#query-builder-test").setValue("qa-guru/qa_guru_14_10").pressEnter();

        $(By.linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();
        $(withText("#2")).should(Condition.exist);










    }





}
