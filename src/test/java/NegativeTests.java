import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class NegativeTests extends BaseTest {

    String invalidNumber = "89225";

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
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNot(appear);
    }

    @Test
    void formWithInvalidNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(invalidNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNot(appear);
    }

    @Test
    void requiredSimpleFormWithoutNameTest() {
        open("/text-box");

        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#name").shouldNot(appear);
        $("#email").shouldNot(appear);
        $("#output #currentAddress").shouldHave(text("Current Address :" + currentAddress));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :" + permanentAddress));
    }
}