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
                .registrationCheck("Student Name", fullName)
                .registrationCheck("Student Email", userEmail)
                .registrationCheck("Gender", gender)
                .registrationCheck("Mobile", userNumber)
                .registrationCheck("Date of Birth", fullDateOfBirth)
                .registrationCheck("Subjects", subjects)
                .registrationCheck("Hobbies", hobbies)
                .registrationCheck("Picture", picture)
                .registrationCheck("Address", currentAddress)
                .registrationCheck("State and City", state + " " + city);
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