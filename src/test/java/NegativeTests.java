import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class NegativeTests extends BaseTest {

    String invalidNumber = "89226";

    @Test
    @DisplayName("Проверка обязательности полей в комплескной форме")
    void fulFillComplexFormWithoutDataTest() {
        step("Открыть главную страницу", () ->
                registrationPage.openPage());
        step("Не заполняя форму еликнуть на Submit", () ->
                registrationPage.clickSubmitForm());
        step("Проверить результат", () -> {
            registrationPage.checkValidateUserForm()
                    .checkTitleNotShow();
        });

    }

    @Test
    @DisplayName("Проверка обязательности заполнения Имени И Фамилии в комплескной форме")
    void formWithoutFullNameTest() {
        step("Открыть главную страницу", () ->
                registrationPage.openPage());
        step("Заполнить форму, указав только гендер и телефон", () -> {
            registrationPage.typeUserGender(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .clickSubmitForm();
        });
        step("Проверить, что title не отображается", () ->
                registrationPage.checkTitleNotShow());
    }

    @Test
    @DisplayName("Проверка обязательности номера в комплескной форме")
    void formWithInvalidNumberTest() {
        step("Открыть главную страницу", () ->
                registrationPage.openPage());
        step("Заполнить форму, указав невалидный номер", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserGender(testData.gender)
                    .typeUserNumber(invalidNumber)
                    .clickSubmitForm();
        });
        step("Проверить, что title не отображается", () ->
                registrationPage.checkTitleNotShow());

    }

    @Test
    @DisplayName("Проверка обязательности поля Имени в простой форме")
    void requiredSimpleFormWithoutNameTest() {
        step("Открыть главную страницу", () ->
                texBoxPage.openPage());
        step("Заполнить форму без указания имени", () -> {
            texBoxPage.typeCurrentAddress(testData.currentAddress)
                    .typePermanentAddress(testData.permanentAddress)
                    .clickSubmitForm();
        });
        step("Проверить, что title не отображается", () -> {
            texBoxPage.checkFieldNotExist("name")
                    .checkFieldNotExist("email")
                    .checkField("currentAddress", testData.currentAddress)
                    .checkField("permanentAddress", testData.permanentAddress);
        });
    }
}