package qa.study.base;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
    }
}
