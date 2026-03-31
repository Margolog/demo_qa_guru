import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTests extends BaseTest {

    @Test
    void fulFillComplexFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("test@test.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("89224567745");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1980");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Beograd");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void requiredFillComplexFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("89224567745");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void requiredSimpleFormTest() {
        open("/text-box");

        $("#userName").setValue("Alex Black");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("Beograd");
        $("#permanentAddress").setValue("Beograd");
        $("#submit").click();

        $("#name").shouldHave(text("Name:Alex Black"));
        $("#email").shouldHave(text("Email:test@test.com"));
        $("#output #currentAddress").shouldHave(text("Current Address :Beograd"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Beograd"));
    }
}