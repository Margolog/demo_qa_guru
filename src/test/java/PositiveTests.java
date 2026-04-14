import org.junit.jupiter.api.Test;

public class PositiveTests extends BaseTest {

    @Test
    void fulFillComplexFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
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
                .clickSubmitForm()
                .checkTitle(testData.successForm)
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
    }

    @Test
    void requiredFillComplexFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserGender(testData.gender)
                .typeUserNumber(testData.userNumber)
                .clickSubmitForm()
                .checkTitle(testData.successForm);
    }

    @Test
    void requiredSimpleFormTest() {
        texBoxPage.openPage()
                .typeUserName(testData.fullName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .clickSubmitForm()
                .checkField("name", testData.fullName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);
    }
}