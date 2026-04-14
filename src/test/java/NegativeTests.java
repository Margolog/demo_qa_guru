import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class NegativeTests extends BaseTest {

    String invalidNumber = "89226";

    @Test
    void fulFillComplexFormWithoutDataTest() {
        registrationPage.openPage()
                .clickSubmitForm()
                .checkValidateUserForm()
                .checkTitleNotShow();

    }

    @Test
    void formWithoutFullNameTest() {
        registrationPage.openPage()
                .typeUserGender(testData.gender)
                .typeUserNumber(testData.userNumber)
                .clickSubmitForm()
                .checkTitleNotShow();
    }

    @Test
    void formWithInvalidNumberTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserGender(testData.gender)
                .typeUserNumber(invalidNumber)
                .clickSubmitForm()
                .checkTitleNotShow();

    }

    @Test
    void requiredSimpleFormWithoutNameTest() {
        texBoxPage.openPage()
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .clickSubmitForm()
                .checkFieldNotExist("name")
                .checkFieldNotExist("email")
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);
    }
}