package qa.study.tests.steps;

import io.qameta.allure.Step;
import qa.study.pages.GitHubPage;

import static com.codeborne.selenide.Selenide.*;

public class ForSelenideAnnotatedTest {
    GitHubPage gitHubPage = new GitHubPage();

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Закрываем браузер")
    public void closeBrowser() {
        closeWebDriver();
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        gitHubPage.submitSearchField(repo);
    }

    @Step("Переходим на страницу репозитория {repo}")
    public void clickOnRepoLink(String repo) {
        gitHubPage.clickOnRepoLink(repo);
    }

    @Step("Открываем таб с проблемами")
    public void clickOnIssueTab() {
        gitHubPage.clickIssueTab();
    }

    @Step("Проверяем наличие проблемы с названием {issue}")
    public void shouldSeeIssueWithName(String issue) {
        gitHubPage.searchIssueName(issue);
    }
}
