package qa.study.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import qa.study.base.BaseTest;
import qa.study.pages.GitHubPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideLambdaTest extends BaseTest {
    protected static final String REPOSITORY = "KnightOS/KnightOS";
    protected static final String ISSUE_NAME = "Fix up KCC CLI";

    @BeforeEach
    public void startUp() {
        setUp();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
    }

    @AfterEach
    public void tearDown() {
        step("Закрываем браузер", () -> {
            closeWebDriver();
        });
    }

    @Test
    public void lambdaIssueNameSearchTest() {
        GitHubPage gitHubPage = new GitHubPage();

        step("Ищем репозиторий " + REPOSITORY, () -> {
            gitHubPage.submitSearchField(REPOSITORY);
        });
        step("Переходим на страницу репозитория " + REPOSITORY, () -> {
            gitHubPage.clickOnRepoLink(REPOSITORY);
        });
        step("Открываем таб с проблемами", () -> {
            gitHubPage.clickIssueTab();
        });
        step("Проверяем наличие проблемы с названием " + ISSUE_NAME, () -> {
            gitHubPage.searchIssueName(ISSUE_NAME);
        });
    }
}
