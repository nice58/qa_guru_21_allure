package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase{

    private static final String NAME_REPOSITORY = "qa-guru/qa_guru_14_10";
    private static final int NUMBER_ISSUE = 2;

    @Test
    @DisplayName("Лямбда шаги через step")
    public void testLambdaStep(){

        step("Поиск репозитория" + NAME_REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(NAME_REPOSITORY).pressEnter();
        });

        step("Клик по ссылки репозитория" + NAME_REPOSITORY, () -> {
            $(By.linkText(NAME_REPOSITORY)).click();
        });

        step("Открытие вкладки Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия Issue c #" + NUMBER_ISSUE, () -> {
            $(withText("#" + NUMBER_ISSUE)).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testAnnotatedStep() {
        WebStepsTest steps = new WebStepsTest();

        steps.searchForRepository(NAME_REPOSITORY);
        steps.clickOnRepositoryLink(NAME_REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER_ISSUE);
    }
}
