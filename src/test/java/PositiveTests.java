import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTests extends BaseTest {

    @Test
    void fulFillComplexFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8922456774");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--030").click();
        $("#dateOfBirthInput").pressTab();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Beograd");
        $("#state input").setValue("NCR").pressEnter();
        $("#city input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("tbody tr").findBy(text("Student Name")).shouldHave(text("Alex Black"));
        $$("tbody tr").findBy(text("Student Email")).shouldHave(text("test@test.com"));
        $$("tbody tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("8922456774"));
        $$("tbody tr").findBy(text("Date of Birth")).shouldHave(text("30 March,2000"));
        $$("tbody tr").findBy(text("Subjects")).shouldHave(text("Maths"));
        $$("tbody tr").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$("tbody tr").findBy(text("Picture")).shouldHave(text("test.jpg"));
        $$("tbody tr").findBy(text("Address")).shouldHave(text("Beograd"));
        $$("tbody tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
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