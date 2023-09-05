package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebStepsTest {

    @Step("Открытие главной страницы")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Поиск репозитория {repo}")
    public void searchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Клик по ссылки репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Открытие вкладки Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия Issue c # {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
