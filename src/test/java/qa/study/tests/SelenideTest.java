package qa.study.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import qa.study.base.BaseTest;
import qa.study.pages.GitHubPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends BaseTest {

    protected static final String REPOSITORY = "KnightOS/KnightOS";
    protected static final String ISSUE_NAME = "Fix up KCC CLI";

    @BeforeEach
    public void startUp() {
        setUp();
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void issueNameSearchTest() {
        GitHubPage gitHubPage = new GitHubPage();
        gitHubPage.submitSearchField(REPOSITORY)
                .clickOnRepoLink(REPOSITORY)
                .clickIssueTab()
                .searchIssueName(ISSUE_NAME);
    }
}
