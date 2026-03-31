import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTests extends BaseTest {

    @Test
    void fulFillComplexFormWithoutDataTest() {
        open("/automation-practice-form");

        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNot(appear);
    }

    @Test
    void formWithoutFullNameTest() {
        open("/automation-practice-form");

        $("#gender-radio-1").click();
        $("#userNumber").setValue("89224567745");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNot(appear);
    }

    @Test
    void formWithInvalidNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("89225");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNot(appear);
    }

    @Test
    void requiredSimpleFormWithoutNameTest() {
        open("/text-box");

        $("#currentAddress").setValue("Beograd");
        $("#permanentAddress").setValue("Beograd");
        $("#submit").click();

        $("#name").shouldNot(appear);
        $("#email").shouldNot(appear);
        $("#output #currentAddress").shouldHave(text("Current Address :Beograd"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Beograd"));
    }
}