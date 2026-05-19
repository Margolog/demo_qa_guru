import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PositiveTests extends BaseTest {

    @Test
    @DisplayName("Заполнение комплексной формы всеми занчениями")
    void fulFillComplexFormTest() {
        step("Открыть главную страницу", () ->
                registrationPage.openPage());
        step("Заполнить форму", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .typeUserGender(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .typeSubjects(testData.subjects)
                    .typeHobbies(testData.hobbies)
                    .uploadPhoto(testData.picturePath)
                    .typeCurrentAddress(testData.currentAddress)
                    .typeState(testData.state)
                    .typeCity(testData.city)
                    .clickSubmitForm();
        });
        step("Проверить результат", () -> {
            registrationPage.checkTitle(testData.successForm)
                    .checkRegistrationResult("Student Name", testData.fullName)
                    .checkRegistrationResult("Student Email", testData.userEmail)
                    .checkRegistrationResult("Gender", testData.gender)
                    .checkRegistrationResult("Mobile", testData.userNumber)
                    .checkRegistrationResult("Date of Birth", testData.fullDateOfBirth)
                    .checkRegistrationResult("Subjects", testData.subjects)
                    .checkRegistrationResult("Hobbies", testData.hobbies)
                    .checkRegistrationResult("Picture", testData.pictureName)
                    .checkRegistrationResult("Address", testData.currentAddress)
                    .checkRegistrationResult("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    @DisplayName("Заполнение комплексной формы обязательными занчениями")
    void requiredFillComplexFormTest() {
        step("Открыть главную страницу", () ->
                registrationPage.openPage());
        step("Заполнить форму обязательными полями", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserGender(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .clickSubmitForm();
        });
        step("Проверить заполненную форму", () ->
                registrationPage.checkTitle(testData.successForm));
    }

    @Test
    @DisplayName("Заполнение простой формы")
    void requiredSimpleFormTest() {
        step("Открыть главную страницу", () ->
                texBoxPage.openPage());
        step("Заполнить данные", () -> {
            texBoxPage.typeUserName(testData.fullName)
                    .typeUserEmail(testData.userEmail)
                    .typeCurrentAddress(testData.currentAddress)
                    .typePermanentAddress(testData.permanentAddress)
                    .clickSubmitForm();
        });
        step("Проверить заполненную форму", () -> {
            texBoxPage.checkField("name", testData.fullName)
                    .checkField("email", testData.userEmail)
                    .checkField("currentAddress", testData.currentAddress)
                    .checkField("permanentAddress", testData.permanentAddress);
        });
    }
}