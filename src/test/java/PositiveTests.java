import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class PositiveTests extends BaseTest {

    @Test
    void fulFillComplexFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--030").click();
        $("#dateOfBirthInput").pressTab();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state input").setValue(state).pressEnter();
        $("#city input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(successForm));
        $$("tbody tr").findBy(text("Student Name")).shouldHave(text(fullName));
        $$("tbody tr").findBy(text("Student Email")).shouldHave(text(userEmail));
        $$("tbody tr").findBy(text("Gender")).shouldHave(text(gender));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text(userNumber));
        $$("tbody tr").findBy(text("Date of Birth")).shouldHave(text(fullDateOfBirth));
        $$("tbody tr").findBy(text("Subjects")).shouldHave(text(subjects));
        $$("tbody tr").findBy(text("Hobbies")).shouldHave(text(hobbies));
        $$("tbody tr").findBy(text("Picture")).shouldHave(text(picture));
        $$("tbody tr").findBy(text("Address")).shouldHave(text(currentAddress));
        $$("tbody tr").findBy(text("State and City")).shouldHave(text(state + " " + city));
    }

    @Test
    void requiredFillComplexFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(successForm));
    }

    @Test
    void requiredSimpleFormTest() {
        open("/text-box");

        $("#userName").setValue(fullName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#name").shouldHave(text("Name:"+ fullName));
        $("#email").shouldHave(text("Email:" + userEmail));
        $("#output #currentAddress").shouldHave(text("Current Address :" + currentAddress));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :" + permanentAddress));
    }
}