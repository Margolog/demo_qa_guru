import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrarionPage;
import pages.TexBoxPage;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    TexBoxPage texBoxPage = new TexBoxPage();
    RegistrarionPage registrarionPage = new RegistrarionPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
