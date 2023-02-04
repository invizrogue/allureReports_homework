package qa.study.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import qa.study.base.BaseTest;
import qa.study.tests.steps.ForSelenideAnnotatedTest;

public class SelenideAnnotatedTest extends BaseTest {
    protected static final String REPOSITORY = "KnightOS/KnightOS";
    protected static final String ISSUE_NAME = "Fix up KCC CLI";

    ForSelenideAnnotatedTest steps = new ForSelenideAnnotatedTest();

    @BeforeEach
    public void startUp() {
        setUp();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
    }

    @AfterEach
    public void tearDown() {
        steps.closeBrowser();
    }

    @Test
    public void annotationsIssueNameSearchTest() {
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepoLink(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
