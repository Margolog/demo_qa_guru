package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationCheckComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    RegistrationCheckComponent registrationCheck = new RegistrationCheckComponent();

    //Elements
    private SelenideElement firstNameInput = element("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#state input");
    private SelenideElement cityInput = $("#city input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResultsTitle = $("#example-modal-sizes-title-lg");
    private SelenideElement userForm = $("#userForm");

    //Actions
    @Step("Открыть automation practice form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Заполнить имя \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить фамилию \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить email \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Заполнить гендер \"{value}\"")
    public RegistrationPage typeUserGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Заполнить номер телефона \"{value}\"")
    public RegistrationPage typeUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    @Step("Заполнить дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setData(day, month, year);
        return this;
    }

    @Step("Заполнить предмет \"{value}\"")
    public RegistrationPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Заполнить дату хобби \"{value}\"")
    public RegistrationPage typeHobbies(String value) {
        hobbiesInput.$$("label")
                .findBy(text(value))
                .click();
        return this;
    }

    @Step("Загрузить фото")
    public RegistrationPage uploadPhoto(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Заполнить адресс \"{value}\"")
    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Заполнить штат")
    public RegistrationPage typeState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Заполнить город")
    public RegistrationPage typeCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Нажать на кнопку submit")
    public RegistrationPage clickSubmitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверить заголовок")
    public RegistrationPage checkTitle(String value) {
        outputResultsTitle.shouldHave(text(value));
        return this;
    }

    @Step("Проверить результат регистрации \"{key}\" и \"{value}\"")
    public RegistrationPage checkRegistrationResult(String key, String value) {
        registrationCheck.checkFormResults(key, value);
        return this;
    }

    @Step("Проверить что форма проваледирована")
    public RegistrationPage checkValidateUserForm() {
        userForm.shouldHave(cssClass("was-validated"));
        return this;
    }

    @Step("Проверить что форма не отображается")
    public RegistrationPage checkTitleNotShow() {
        outputResultsTitle.shouldNotBe(visible);
        return this;
    }
}
