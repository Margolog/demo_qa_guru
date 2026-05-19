import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import pages.TextBoxPage;
import testdata.TestData;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    TextBoxPage texBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData;

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void setUpTestData() {
        testData = new TestData();
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
