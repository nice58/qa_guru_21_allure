package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest{

    private static final String NAME_REPOSITORY = "selenide/selenide";
    private static final int NUMBER_ISSUE = 2434;

    @Test
    @DisplayName("Лямбда шаги через step")
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открытие главной страницы", () -> {
            open("https://github.com");
        });

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
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTest steps = new WebStepsTest();

        steps.openMainPage();
        steps.searchForRepository(NAME_REPOSITORY);
        steps.clickOnRepositoryLink(NAME_REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER_ISSUE);
    }
}
