import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class PositiveTests extends BaseTest {

    @Test
    void fulFillComplexFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .typeSubjects(subjects)
                .typeHobbies(hobbies)
                .uploadPhoto(picture)
                .typeCurrentAddress(currentAddress)
                .typeState(state)
                .typeCity(city)
                .clickSubmitForm()
                .checkTitle(successForm)
                .checkRegistrationResult("Student Name", fullName)
                .checkRegistrationResult("Student Email", userEmail)
                .checkRegistrationResult("Gender", gender)
                .checkRegistrationResult("Mobile", userNumber)
                .checkRegistrationResult("Date of Birth", fullDateOfBirth)
                .checkRegistrationResult("Subjects", subjects)
                .checkRegistrationResult("Hobbies", hobbies)
                .checkRegistrationResult("Picture", picture)
                .checkRegistrationResult("Address", currentAddress)
                .checkRegistrationResult("State and City", state + " " + city);
    }

    @Test
    void requiredFillComplexFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserGender(gender)
                .typeUserNumber(userNumber)
                .clickSubmitForm()
                .checkTitle(successForm);
    }

    @Test
    void requiredSimpleFormTest() {
        texBoxPage.openPage()
                .typeUserName(fullName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .clickSubmitForm()
                .checkField("name", fullName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }
}