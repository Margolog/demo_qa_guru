import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.TextBoxPage;
import testdata.TestData;


import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    TextBoxPage texBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData;


    @BeforeAll
    static void setup() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserResolution", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless","true"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.savePageSource = true;
        Configuration.screenshots = true;
        Configuration.remote = System.getProperty("remote");

        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            String[] possiblePaths = {
                    "/usr/bin/chromedriver",
                    "/usr/local/bin/chromedriver",
                    "/snap/bin/chromedriver"
            };

            for (String path : possiblePaths) {
                if (new java.io.File(path).exists()) {
                    System.setProperty("webdriver.chrome.driver", path);
                    break;
                }
            }
        }

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @BeforeEach
    void setUpTestData() {
        testData = new TestData();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
