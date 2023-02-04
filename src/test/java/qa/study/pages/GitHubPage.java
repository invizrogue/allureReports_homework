package qa.study.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class GitHubPage {
    final static SelenideElement searchField = $(".header-search-input");
    final static SelenideElement issueTab = $("#issues-tab");

    public GitHubPage submitSearchField(String repo) {
        searchField.click();
        searchField.sendKeys(repo);
        searchField.submit();
        return this;
    }

    public GitHubPage clickIssueTab() {
        issueTab.click();
        return this;
    }

    public GitHubPage clickOnRepoLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }

    public GitHubPage searchIssueName(String issueName) {
        $(withText(issueName)).should(exist);
        return this;
    }
}
