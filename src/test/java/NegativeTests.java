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
                .typeUserGender(gender)
                .typeUserNumber(userNumber)
                .clickSubmitForm()
                .checkTitleNotShow();
    }

    @Test
    void formWithInvalidNumberTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserGender(gender)
                .typeUserNumber(invalidNumber)
                .clickSubmitForm()
                .checkTitleNotShow();

    }

    @Test
    void requiredSimpleFormWithoutNameTest() {
        texBoxPage.openPage()
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .clickSubmitForm()
                .checkFieldNotExist("name")
                .checkFieldNotExist("email")
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }
}