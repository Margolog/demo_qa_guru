import com.codeborne.selenide.Configuration;
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
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
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
